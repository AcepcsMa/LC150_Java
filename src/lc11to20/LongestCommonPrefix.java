package lc11to20;

/**
 * @author Haoxiang Ma
 * Leetcode #14
 * Longest Common Prefix
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix solution = new LongestCommonPrefix();
	}

	/**
	 * 思路: 取第一个str作为prefix, 逐个匹配下去, 匹配就移动到下一个str,
	 * 不匹配时使其长度减1, 以此类推直到prefix的长度为0或者匹配完所有的str。
	 * @param strs strs
	 * @return prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for(int i = 0;i < strs.length;i++) {
			while(strs[i].indexOf(prefix) != 0) {	// 当前不匹配就尝试减短prefix长度
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()) {
					return "";	// prefix减到长度为0时, 说明没有公共prefix
				}
			}
		}
		return prefix;
	}
}
