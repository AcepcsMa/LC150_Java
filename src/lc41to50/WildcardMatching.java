package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #44
 * Wildcard Matching
 */
public class WildcardMatching {

	public static void main(String[] args) {
		WildcardMatching solution = new WildcardMatching();
	}

	/**
	 * 思路: 类似于regular expression那道题, 不同点在于本题中的'*'可以匹配
	 * 任意长度的字符串, 不再是之前那题里匹配前一字符N次。
	 * @param s s
	 * @param p p
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		// 处理特殊情况, s为空串时
		for(int j = 1;j <= p.length();j++) {
			if(p.charAt(j - 1) != '*') {
				break;	// 对于空串s而言, 一旦遇到p里不是*的位置, 肯定就不能匹配了
			}
			dp[0][j] = true;
		}

		for(int i = 1;i <= s.length();i++) {
			for(int j = 1;j <= p.length();j++) {
				// 当前对应字符相同时, s[0...i]和p[0...j]能否匹配取决于s[0...i-1]和p[0...j-1]能否匹配
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				// 当前对应字符不同, 且遇到了*时, 要用*匹配任意字符串
				if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
