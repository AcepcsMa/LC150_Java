package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #7
 * Reverse Integer
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger solution = new ReverseInteger();
	}

	/**
	 * 思路: 不断地通过求余操作取当前最后一位数字, 放到结果的高位，
	 * 并在过程中检测整形溢出的问题
	 * @param x x
	 * @return reverse
	 */
	public int reverse(int x) {
		int num = Math.abs(x);
		int sum = 0;

		while(num > 0) {
			if(sum > Integer.MAX_VALUE / 10) {
				return 0;	// 按照题目要求, 溢出时返回0
			}
			int temp = num % 10;
			sum = sum * 10 + temp;
			num /= 10;
		}
		return x < 0 ? -sum : sum;
	}
}
