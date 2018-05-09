package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #5
 * Longest Palindromic Substring
 */
public class LongestPalindromic {

	public static void main(String[] args) {
		LongestWithoutRepeat solution = new LongestWithoutRepeat();
	}

	/**
	 * 思路: 利用dp的思想, 如果知道了s[i+1...j-1]是palindromic的, 那么
	 * 当s[i] == s[j]时, s[i...j]肯定是palindromic的。 单个字符肯定是
	 * palindromic的
	 * @param s s
	 * @return longest length
	 */
	public String longestPalindrome(String s) {
		int length = 0;
		String result = "";
//		boolean[][] dp = new boolean[s.length()][s.length()];
		boolean[] dp = new boolean[s.length()];	// 可优化至只使用一维dp数组

		for(int i = s.length() - 1;i >= 0;i--) {
			for(int j = s.length() - 1;j >= i;j--) {
//				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//				if(dp[i][j] == true && j + 1 - i > length) {
//					length = j + 1 - i;
//					result = s.substring(i, j + 1);
//				}

				// 一首一尾的字符相等 并且 当前串长度小于等于3或者内部串也是palindromic
				// 例如aba, axyyxa
				dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
				if(dp[j] == true && j + 1 - i > length) {
					length = j + 1 - i;
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}
}
