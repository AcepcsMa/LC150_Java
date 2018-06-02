package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #70
 * Climbing Stairs
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs solution = new ClimbingStairs();
	}

	/**
	 * 思路: dp。到达第n阶楼梯有多少种走法 取决于 到达n-1和n-2有多少种走法。
	 * 因为第n阶可从第n-1阶和第n-2阶跨上去。
	 * @param n n
	 * @return num of solutions
	 */
	public int climbStairs(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i <= n;i++) {
			dp[n] = dp[n - 1] + dp[n - 2];
		}
		return dp[n];
	}
}
