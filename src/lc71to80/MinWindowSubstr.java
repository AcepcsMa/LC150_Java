package lc71to80;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haoxiang Ma
 * Leetcode #76
 * Minimum Window Substring
 */
public class MinWindowSubstr {

	public static void main(String[] args) {
		MinWindowSubstr solution = new MinWindowSubstr();
	}

	/**
	 * 思路: two pointer从左到右扫描。记录已经找到的字符个数, 一旦找齐
	 * 就挪动左指针, 向右挪动直到找到的字符个数不足t的长度为止。
	 * @param s s
	 * @param t t
	 * @return min window substr
	 */
	public String minWindow(String s, String t) {
		if(s == null || t == null || s.length() < t.length()) {
			return null;
		}

		Map<Character, Integer> map = new HashMap<>();
		String result = "";
		int length = Integer.MAX_VALUE;
		int find = 0;
		int left = 0, right = 0;

		for(int i = 0;i < t.length();i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);	// 先把t中的字符记录下来
		}

		while(right < s.length()) {
			Integer rightCount = map.get(s.charAt(right));
			if(rightCount != null) {
				map.put(s.charAt(right), rightCount - 1);
				if(rightCount - 1 >= 0) {
					find++;	// 找到一个需要的字符就使find自增, find用于表明有多少个需要的字符已经被找到
				}
			}

			// 一旦所需的字符全都找齐了, 就开始挪动左指针
			while(find == t.length()) {
				Integer leftCount = map.get(s.charAt(left));
				if(leftCount != -1) {
					map.put(s.charAt(left), leftCount + 1);
					if(leftCount + 1 > 0) {
						if(right + 1 - left < length) {	// 更新最小窗口值
							length = right + 1 - left;
							result = s.substring(left, right + 1);
						}
						find--;
					}
				}
				left++;
			}
			right++;
		}
		return result;
	}
}
