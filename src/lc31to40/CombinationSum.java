package lc31to40;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #39
 * Combination Sum
 */
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
	}

	/**
	 * 思路: DFS。由于每个数都能被复用, 所以DFS到下一层时仍然可以用当前的index。
	 * @param candidates candidates
	 * @param target target
	 * @return combination sum
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(candidates == null || candidates.length == 0) {
			return result;
		}
		dfs(result, new LinkedList<>(), candidates, target, 0);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index) {
		if(target == 0) {
			result.add(new LinkedList<>(path));
		} else {
			for(int i = index;i < candidates.length;i++) {
				if(target - candidates[i] >= 0) {
					path.add(candidates[i]);
					dfs(result, path, candidates, target - candidates[i], i);
					path.remove(path.size() - 1);
				}
			}
		}
	}
}
