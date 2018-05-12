package lc11to20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #17
 * Letter Combinations of a Phone Number
 */
public class LetterCombination {

	public static void main(String[] args) {
		LetterCombination solution = new LetterCombination();
	}

	/**
	 * 思路: 求出*所有*字母组合, 求所有解的问题首先要考虑DFS。 利用DFS
	 * 遍历字母组合的解空间，走到尽头时将组合加入结果集合中。
	 * @param digits digits
	 * @return combinations
	 */
	public List<String> letterCombinations(String digits) {
		String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return result;
		}

		dfs(result, "", digits, 0, dict);
		return result;
	}

	/**
	 * DFS
	 * @param result result
	 * @param path path
	 * @param digits digits
	 * @param index index
	 * @param dict dict
	 */
	public void dfs(List<String> result, String path, String digits, int index, String[] dict) {
		if(path.length() == digits.length()) {
			result.add(path);
			return;
		}
		String chars = dict[digits.charAt(index) - '0'];	// 当前数字对应的字符可能性
		for(int i = 0;i < chars.length();i++) {
			dfs(result, path + chars.charAt(i), digits, index + 1, dict);	// DFS到下一层
		}
	}
}
