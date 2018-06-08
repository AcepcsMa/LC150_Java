package lc71to80;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #77
 * Combinations
 */
public class Combinations {

	public static void main(String[] args) {
		Combinations solution = new Combinations();
	}

	/**
	 * 思路: DFS。每次只能取当前元素后面的剩余元素。
	 * @param n n
	 * @param k k
	 * @return combinations
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), 1, n, k);
		return result;
	}

	/**
	 * DFS。
	 * @param result result
	 * @param path path
	 * @param num num
	 * @param n n
	 * @param k k
	 */
	public void dfs(List<List<Integer>> result, List<Integer> path, int num, int n, int k) {
		if(path.size() == k) {
			result.add(new ArrayList<>(path));
		} else {
			for(int i = num;i <= n;i++) {
				path.add(i);
				dfs(result, path, i + 1, n, k);
				path.remove(path.size() - 1);
			}
		}
	}
}
