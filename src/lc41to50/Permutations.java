package lc41to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #46
 * Permutations
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations solution = new Permutations();
	}

	/**
	 * 思路: 求"所有"permutations, 很自然想到DFS。由于题目所给的输入数组里
	 * 全部都是distinct数值, 所以去重的策略只需要简单地使用一个boolean数组
	 * 以指示哪个元素被使用过了即可。
	 * @param nums nums
	 * @return permutations
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
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
			result.add(new LinkedList<>(path));	// 终止状态
		} else {
			for(int i = 0;i < nums.length;i++) {
				if(!used[i]) {
					used[i] = true;
					path.add(nums[i]);
					dfs(result, path, nums, used);
					path.remove(path.size() - 1);	// 回溯
					used[i] = false;
				}
			}
		}
	}
}
