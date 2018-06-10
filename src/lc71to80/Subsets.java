package lc71to80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #78
 * Subsets
 */
public class Subsets {

	public static void main(String[] args) {
		Subsets solution = new Subsets();
	}

	/**
	 * 思路: DFS。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}

		dfs(result, new ArrayList<>(), nums, 0);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
		if(index >= nums.length) {
			return;
		}

		result.add(new ArrayList<>(path));
		for(int i = index;i < nums.length;i++) {
			path.add(nums[i]);
			dfs(result, path, nums, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
