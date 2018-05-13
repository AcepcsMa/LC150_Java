package lc11to20;

import java.util.Stack;

/**
 * @author Haoxiang Ma
 * Leetcode #20
 * Valid Parentheses
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
	}

	/**
	 * 思路: 用栈进行括号的匹配。当前遇到左括号不管三七二十一就入栈; 当前遇到
	 * 右括号, 如果栈为空那就肯定invalid, 如果栈不空则看看栈顶的左括号能不能
	 * 与当前的右括号匹配。最后检查栈里还有没有剩余元素, 如果有剩余元素则说明
	 * 左右括号不能完全1:1匹配完。
	 * @param s s
	 * @return true/false
	 */
	public boolean isValid(String s) {
		if(s == null || s.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for(char ch : chars) {
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);	// 当前遇到左括号, 无脑入栈
			} else {
				if(stack.isEmpty()) {
					return false;	// 当前遇到右括号, 栈又为空肯定invalid
				} else {
					char prev = stack.pop();	// 弹出栈顶元素, 看看能不能成功匹配
					if(ch == ')' && prev != '(' || ch == ']' && prev != '[' || ch == '}' && prev != '{') {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
}
