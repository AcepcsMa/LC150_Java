package lc31to40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #40
 * Combination Sum II
 */
public class CombinationSumII {

	public static void main(String[] args) {
		CombinationSumII solution = new CombinationSumII();
	}

	/**
	 * 思路: DFS。由于每个数只能使用一次, 且最终结果需要去重, 所以要先对原数组进行排序。
	 * 并且在DFS走到下一层时, index++。
	 * @param candidates candidates
	 * @param target target
	 * @return combination sum
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		dfs(result, new LinkedList<>(), candidates, target, 0);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index) {
		if(target == 0) {
			result.add(new LinkedList<>(path));
		} else {
			for(int i = index;i < candidates.length;i++) {
				if(i > index && candidates[i] == candidates[i - 1]) {
					continue;
				}
				if(target - candidates[i] >= 0) {
					path.add(candidates[i]);
					dfs(result, path, candidates, target - candidates[i], i + 1);
					path.remove(path.size() - 1);
				}
			}
		}
	}
}
