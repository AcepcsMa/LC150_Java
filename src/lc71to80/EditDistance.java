package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #72
 * Edit Distance
 */
public class EditDistance {

	public static void main(String[] args) {
		EditDistance solution = new EditDistance();
	}

	/**
	 * 思路: dp。假设串1的长度为i, 串2的长度为j, 那么问题就相当于求f(i, j), f(i, j)
	 * 代表了长度为i的串转换为长度为j的串最少需要多少步。子问题是f(i - 1, j), f(i, j - 1)
	 * 还有f(i - 1, j - 1)。
	 * @param word1 word1
	 * @param word2 word2
	 * @return min dist
	 */
	public int minDistance(String word1, String word2) {
		if(word1 == null || word2 == null) {
			return -1;
		}
		int len1 = word1.length(), len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for(int i = 0;i <= len1;i++) {
			for(int j = 0;j <= len2;j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = i == 0 ? j : i;	// 如果有一个是空串, 那么变换到另一个串的最小代价就是其长度
				} else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];	// 如果当前字符是一样的, 最小代价取决于长度减一的短串
				} else {
					// 当前字符不一样, 最小代价取决于增/删/替换哪个更优
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[len1][len2];
	}
}
