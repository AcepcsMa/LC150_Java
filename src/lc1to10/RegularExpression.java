package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #10
 * Regular Expression Matching
 */
public class RegularExpression {

	public static void main(String[] args) {
		RegularExpression solution = new RegularExpression();
	}

	/**
	 * 思路: 利用dp的思想, 要想知道s[0...i]和p[0...j]能不能匹配, 取决于s[i]和s[j]是否匹配
	 * 以及s[0...i-1]和p[0...j-1]的匹配情况
	 * @param s s
	 * @param p p
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		// 处理特殊情况, s为空串时, 要去检查p里的*, 因为*可以忽略前一字符, 有一定可能成功匹配空串
		for(int j = 2;j <= p.length();j++) {
			if(p.charAt(j - 1) == '*' && dp[0][j - 2]) {
				dp[0][j] = true;
			}
		}

		// 非空情况下, 填充dp数组
		for(int i = 1;i <= s.length();i++) {
			for(int j = 1;j <= p.length();j++) {
				// 当前s和p的最后一个字符相同 or p最后一个字符能匹配万事万物,
				// 那么dp[i][j] 就取决于 dp[i-1][j-1]
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}

				// 当前p的最后一个字符是*, 可匹配前一字符0次, 1次, n次
				if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2]	// 匹配前一字符0次
						|| ((p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j]);	// 匹配前一字符1次或n次
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
