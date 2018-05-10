package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #9
 * Palindrome Number
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber solution = new PalindromeNumber();
	}

	/**
	 * 思路: 循环检测当前数字的最高位和最低位, 如果一致就去掉最高位和最低位, 继续循环。
	 * 如果不一致, 立马返回false
	 * @param x x
	 * @return true/false
	 */
	public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;	// 负数肯定不是palindromic
		}

		// 求出最高位的权重, 例如6666, 最高位权重就是1000
		int y = x;
		int digit = 1;
		while(y >= 10) {
			digit *= 10;
			y /= 10;
		}

		while(x > 0) {
			int higher = (x / digit) % 10;	// 最高位数字
			int lower = x % 10;	// 最低位数字
			if(higher != lower) {
				return false;
			}

			x -= digit * higher;	// 砍掉最高位数字
			x /= 10;	// 砍掉最低位数字
			digit /= 100;	// 调整最高位权重, 因为砍掉了2个数字所以权重下降了10^2
		}
		return true;
	}
}
