package lc41to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #47
 * Permutations II
 */
public class PermutationsII {

	public static void main(String[] args) {
		PermutationsII solution = new PermutationsII();
	}

	/**
	 * 思路: DFS。由于原数组中可能存在duplicate numbers, 所以要专门
	 * 进行去重。
	 * @param nums nums
	 * @return permutations
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		dfs(result, new LinkedList<>(), nums, used);
		return result;
	}

	/**
	 * DFS。
	 * @param result result
	 * @param path path
	 * @param nums nums
	 * @param used used
	 */
	public void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			result.add(new LinkedList<>(path));
		} else {
			for(int i = 0;i < nums.length;i++) {
				if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
					continue;	// 去重, 如果当前元素已被用过, 或者当前元素和前一元素相同且前一元素没被用过
				}
				path.add(nums[i]);
				used[i] = true;
				dfs(result, path, nums, used);
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}
}
