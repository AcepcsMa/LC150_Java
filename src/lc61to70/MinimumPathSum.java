package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #64
 * Minimum Path Sum
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		MinimumPathSum solution = new MinimumPathSum();
	}

	/**
	 * 思路: 还是dp。走到一个格子处的min sum = Min(走到其上方格子的min sum, 走到其左边格子的min sum)
	 * + 当前格子的value。
	 * @param grid grid
	 * @return min path sum
	 */
	public int minPathSum(int[][] grid) {
		if(grid == null) {
			return 0;
		}

		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else if(i == 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if(j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
