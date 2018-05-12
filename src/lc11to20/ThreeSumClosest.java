package lc11to20;

import java.util.Arrays;

/**
 * @author Haoxiang Ma
 * Leetcode #16
 * 3Sum Closest
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = {0, 2, 1, -3};
		int target = 1;
		ThreeSumClosest solution = new ThreeSumClosest();
		solution.threeSumClosest(nums, target);
	}

	/**
	 * 思路: 跟3Sum一样, 先对原数组排序, 基于有序数组可使用two pointer
	 * 解法。 唯一不同的在于此题不需要返回所有组合。
	 * @param nums nums
	 * @param target target
	 * @return closest
	 */
	public int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length < 3) {
			throw new RuntimeException();
		}

		Arrays.sort(nums);

		int closest = nums[0] + nums[1] + nums[2];
		for(int i = 0;i < nums.length - 2;i++) {
			int head = i + 1;
			int tail = nums.length - 1;
			while(head < tail) {
				int temp = nums[i] + nums[head] + nums[tail];
				if(Math.abs(temp - target) < Math.abs(closest - target)) {
					closest = temp;
				} else if(temp < target) {
					head++;
				} else {
					tail--;
				}
			}
		}
		return closest;
	}
}
