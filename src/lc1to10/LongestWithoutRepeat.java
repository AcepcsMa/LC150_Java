package lc1to10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haoxiang Ma
 * Leetcode #3
 * Longest Substring Without Repeating Characters
 */
public class LongestWithoutRepeat {

	public static void main(String[] args) {
		LongestWithoutRepeat solution = new LongestWithoutRepeat();
		String s = "abcabcbb";
		System.out.println(solution.lengthOfLongestSubstring(s));
	}

	/**
	 * 思路: 双指针+滑动窗口, 遇到重复字符时左指针就向右移动
	 * Trick: 用一个Map来记录字符和index之间的映射, 可快速定位到某字符之前出现过的位置
	 * @param s s
	 * @return length
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty()) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int length = 0;
		int left = 0, right = 0;
		while(right < s.length()) {
			int index = map.getOrDefault(s.charAt(right), -1);	// 检查当前字符是否已经出现过
			if(index != -1) {
				// 当前字符确实在之前出现过的话，让左指针挪动到其出现位置的下一位 (从而"避开"这个重复的字符)
				left = Math.max(left, index + 1);
			}
			length = Math.max(length, right + 1 - left);
			map.put(s.charAt(right), right);
			right++;
		}
		return length;
	}
}
