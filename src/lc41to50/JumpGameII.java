package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #45
 * Jump Game II
 */
public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII solution = new JumpGameII();
	}

	/**
	 * 思路: 贪心算法。维护一个全局可到达的最远位置max, 维护一个当前
	 * 可到达的最远位置boundary, 当走到boundary的时候意味着一定要
	 * 再跳一下才能继续前进, 所以此时jump count++。
	 * @param nums nums
	 * @return min jump count
	 */
	public int jump(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}

		int max = 0;
		int boundary = 0;
		int step = 0;

		for(int i = 0;i < nums.length - 1;i++) {
			max = Math.max(max, i + nums[i]);	// 全局可到达的最远位置
			if(i == boundary) {	// 当走到了boundary位置时, 必须跳一跳了
				step++;
				boundary = max;	// 新的boundary(极限位置)就是全局最远位置
			}
		}
		return step;
	}
}
