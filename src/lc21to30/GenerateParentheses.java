package lc21to30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #22
 * Generate Parentheses
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses solution = new GenerateParentheses();
	}

	/**
	 * 思路: 生成"所有"解, 首先考虑DFS。DFS每走一步，我们可以添加一个左括号 or 右括号,
	 * 当剩余可用左括号数 < 剩余可用右括号数时, 左右括号均可添加; 当剩余可用左括号数 >= 可用
	 * 右括号数时, 只能添加左括号。
	 * @param n n
	 * @return combinations
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if(n <= 0) {
			return result;
		}
		dfs(result, "", n, n);
		return result;
	}

	public void dfs(List<String> result, String path, int leftCount, int rightCount) {
		if(leftCount == 0 && rightCount == 0) {
			result.add(path);
		} else {
			// 只要有剩余的左括号, 就可以无脑添加左括号
			if(leftCount > 0) {
				dfs(result, path + "(", leftCount - 1, rightCount);
			}
			// 当有剩余的右括号, 且剩余的右括号数 > 剩余的左括号数时, 才能添加右括号
			if(rightCount > 0 && leftCount < rightCount) {
				dfs(result, path + ")", leftCount, rightCount - 1);
			}
		}
	}
}
