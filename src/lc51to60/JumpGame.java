package lc51to60;

/**
 * @author Haoxiang Ma
 * Leetcode #55
 * Jump Game
 */
public class JumpGame {

	public static void main(String[] args) {
		JumpGame solution = new JumpGame();
	}

	/**
	 * 思路: 贪心算法, 一直更新最远可达到的坐标, 一旦走到不可到达的坐标就返回false。
	 * @param nums nums
	 * @return true/false
	 */
	public boolean canJump(int[] nums) {
		int max = 0;
		for(int i = 0;i < nums.length;i++) {
			if(max < i) {
				return false;
			}
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}
}
