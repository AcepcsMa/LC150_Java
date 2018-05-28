package lc51to60;

/**
 * @author Haoxiang Ma
 * Leetcode #53
 * Maximum Subarray
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray solution = new MaximumSubarray();
	}

	/**
	 * 思路: 源于一个朴素的想法, 维护一个全局的max和一个局部的sum。
	 * 从左到右遍历数组, 遇到每一个数, 如果sum + nums[i] >= nums[i],
	 * 则说明把当前这个nums[i]纳入我的sum, 比从当前这个地方从头开始累加要好。
	 * 如果sum + nums[i] < nums[i], 则说明把当前这个nums[i]纳入我的sum,
	 * 比从当前这个地方从头开始累加要差, 那就不如就地从头开始。
	 * @param nums nums
	 * @return max subarray sum
	 */
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int num : nums) {
			if(sum >= 0) {	// sum >=0 等价于 sum + nums[i] >= nums[i]
				sum += num;	// 继续把当前元素纳入sum
			} else {	// sum < 0 等价于 sum + nums[i] < nums[i]
				sum = num; 	// 就地从头开始累加
			}
			max = Math.max(max, sum);	// 更新全局max
		}
		return max;
	}
}
