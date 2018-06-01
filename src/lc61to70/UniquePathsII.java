package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #63
 * Unique Paths II
 */
public class UniquePathsII {

	public static void main(String[] args) {
		UniquePathsII solution = new UniquePathsII();
	}

	/**
	 * 思路: 跟Unique Paths思路一样, 利用dp的想法解题。不同的是多了"障碍物",
	 * 需要在dp过程中当作特殊情况处理。
	 * @param obstacleGrid grid
	 * @return num of paths
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null) {
			return 0;
		}
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				if(obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;	// 遇到障碍物, 走到障碍物处的path数为0
				} else {
					if(i == 0 && j == 0) {
						dp[i][j] = 1;
					} else if(i == 0) {
						dp[i][j] = obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];	// 判断前一格是否障碍物
					} else if(j == 0) {
						dp[i][j] = obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];	// 判断前一格是否障碍物
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
