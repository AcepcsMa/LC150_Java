package lc41to50;

import java.util.*;

/**
 * @author Haoxiang Ma
 * Leetcode #49
 * Group Anagrams
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
	}

	/**
	 * 思路: 利用Anagram的特性, 如果两个字符串是anagram的话它们排序后是一模一样的。
	 * 所以可设置一个HashMap, 以字符串为key, 排序后相同的字符串归到同一个key下面。
	 * @param strs strs
	 * @return anagrams
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if(strs == null || strs.length == 0) {
			return result;
		}

		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);	// 如果两者是anagram, 排序后的结果肯定一样
			String curStr = new String(chars);
			if(!map.containsKey(curStr)) {
				List<String> anagrams = new ArrayList<>();
				anagrams.add(str);
				map.put(curStr, anagrams);
			} else {
				map.get(curStr).add(str);
			}
		}

		for(List<String> anagrams : map.values()) {
			result.add(anagrams);
		}
		return result;
	}
}
