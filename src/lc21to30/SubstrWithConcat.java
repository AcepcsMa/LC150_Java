package lc21to30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Haoxiang Ma
 * Leetcode #30
 * Substring with Concatenation of All Words
 */
public class SubstrWithConcat {

	public static void main(String[] args) {
		SubstrWithConcat solution = new SubstrWithConcat();
	}

	/**
	 * 思路: 牺牲空间, 利用HashMap记录下所有词以及出现次数。遍历字符串s,
	 * 对里面的单词用HashMap进行匹配。
	 * @param s s
	 * @param words words
	 * @return indices
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		Map<String, Integer> map = new HashMap<>();
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		int wordLen = words[0].length();

		for(int i = 0;i < s.length() - words.length * wordLen + 1;i++) {
			Map<String, Integer> tempMap = new HashMap<>(map);
			for(int j = i;j < s.length() - wordLen + 1;j += wordLen) {
				String cur = s.substring(j, j + wordLen);
				if(!tempMap.containsKey(cur)) {
					break;
				} else {
					tempMap.put(cur, tempMap.get(cur) - 1);
					if(tempMap.get(cur) == 0) {
						tempMap.remove(cur);
					}
				}
			}
			if(tempMap.isEmpty()) {
				result.add(i);
			}
		}
		return result;
	}
}
