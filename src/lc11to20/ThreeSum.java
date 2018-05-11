package lc11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #15
 * 3Sum
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum solution = new ThreeSum();
	}

	/**
	 * 思路: 升级版2Sum, 每次先假定一个元素, 然后在其后面的数里找到剩余2个数构成target(0)。
	 * 优化: 由于题目不要求求出index, 只要求求出具体的数的组合, 所以可以先将原数组排好序,
	 * 对于有序的数组, 就可以使用two pointer的常用解法去做。同时K-Sum问题的时间复杂度上界
	 * 为O(N^(K-1)), 当K = 3时, 复杂度上界为O(N^2), 所以排序并不会改变原算法时间复杂度的量级。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);	// 先排序, 对于有序数组就可以用two pointer解法

		for(int i = 0;i < nums.length;i++) {
			// 去重, 当前元素和前一元素相同, 那么就会产生重复组合
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// two pointer, 一头一尾挪动
			int head = i + 1;
			int tail = nums.length - 1;
			while(head < tail) {
				int temp = nums[i] + nums[head] + nums[tail];
				if(temp == 0) {
					result.add(Arrays.asList(nums[i], nums[head], nums[tail]));	// 找到目标组合后, 挪动头尾指针
					head++;
					tail--;
					while(head < tail && nums[head] == nums[head - 1]) {
						head++;
					}
					while(head < tail && nums[tail] == nums[tail + 1]) {
						tail--;
					}
				} else if(temp < 0) {
					head++;	// 组合值偏小, 需要挪动头指针找到大一点的数
				} else {
					tail--;	// 组合值偏大, 需要挪动尾指针找到小一点的数
				}
			}
		}
		return result;
	}
}
