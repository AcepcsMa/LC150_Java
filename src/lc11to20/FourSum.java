package lc11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #18
 * 4Sum
 */
public class FourSum {

	public static void main(String[] args) {
		FourSum solution = new FourSum();
	}

	/**
	 * 思路: 升级版3Sum, 与3Sum同理, 需要先对原数组排序, 在有序数组上可应用
	 * two pointer解法。 要注意去重等细节。
	 * @param nums nums
	 * @param target target
	 * @return four sums
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length < 4) {
			return result;
		}

		Arrays.sort(nums);

		for(int i = 0;i < nums.length - 3;i++) {	// 4- Sum
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for(int j = i + 1;j < nums.length - 2;j++) {	// 3-Sum
				if(j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int head = j + 1;
				int tail = nums.length - 1;
				while(head < tail) {	// two pointer
					int temp = nums[i] + nums[j] + nums[head] + nums[tail];
					if(temp == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
						head++;
						tail--;
						while(head < tail && nums[head] == nums[head - 1]) {
							head++;
						}
						while(head < tail && nums[tail] == nums[tail + 1]) {
							tail--;
						}
					} else if(temp < target) {
						head++;
					} else {
						tail--;
					}
				}
			}
		}
		return result;
	}
}
