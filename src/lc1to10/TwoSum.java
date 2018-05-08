package lc1to10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Haoxiang Ma
 * Leetcode #1
 * Two Sum
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		TwoSum solution = new TwoSum();
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));
	}

	/**
	 * 思想: 牺牲空间复杂度，利用Map来记录值与index的映射关系，可快速定位某个值的坐标
	 * @param nums nums
	 * @param target target
	 * @return int[]
	 */
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length < 2) {
			return new int[]{-1, -1};
		}

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			int rest = target - nums[i];	// 计算差值
			int index = map.getOrDefault(rest, -1);	// 看看差值是否存在
			if(index != -1) {
				return new int[]{index, i};
			}
			map.put(nums[i], i);
		}
		return new int[]{-1, -1};
	}
}
