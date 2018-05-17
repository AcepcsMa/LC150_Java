package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #32
 * Longest Valid Parentheses
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses solution = new LongestValidParentheses();
	}

	/**
	 * 思路: 从左向右遍历, 记录左括号数和右括号数, 当左 = 右时更新全局max,
	 * 当右 > 左时括号数置零; 然后从右向左遍历, 相反的逻辑重新做一遍。
	 * @param s s
	 * @return length
	 */
	public int longestValidParentheses(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int max = 0;
		int left = 0, right = 0;
		char[] chars = s.toCharArray();

		// 从左向右扫描
		for(int i = 0;i < chars.length;i++) {
			if(chars[i] == '(') {
				left++;
			} else {
				right++;
			}
			if(left == right) {
				max = Math.max(max, left * 2);
			} else if(right > left) {
				left = right = 0;
			}
		}

		// 从右向左扫描
		left = right = 0;
		for(int i = chars.length - 1;i >= 0;i--) {
			if(chars[i] == ')') {
				right++;
			} else {
				left++;
			}
			if(left == right) {
				max = Math.max(max, left * 2);
			} else if(left > right) {
				left = right = 0;
			}
		}
		return max;
	}
}
