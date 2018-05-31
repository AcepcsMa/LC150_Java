package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #62
 * Unique Paths
 */
public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths solution = new UniquePaths();
	}

	/**
	 * 思路: dp。每一步都只能往右or往下, 那么到达最右下格子的路径数 =
	 * 到达其上方格子的路径数, 到达其左边格子的路径数。
	 * Base case是第一行or第一列, 永远只有一种走法, 直接一条路走过去。
	 * @param m m
	 * @param n n
	 * @return num of paths
	 */
	public int uniquePaths(int m, int n) {
		if(m <= 0 || n < 0) {
			return 0;
		}

		int[][] dp = new int[m][n];
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 1;	// 第一行或者第一列, 只有一种走法
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];	// 其他格子, 取决于其上方+其左边的路径数
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
