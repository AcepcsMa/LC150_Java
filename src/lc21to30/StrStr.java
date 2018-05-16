package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #28
 * Implement strStr()
 */
public class StrStr {

	public static void main(String[] args) {
		StrStr solution = new StrStr();
	}

	/**
	 * 思路: KMP算法, 先求出next数组, 再基于next数组进行匹配。
	 * @param haystack haystack
	 * @param needle needle
	 * @return index
	 */
	public int strStr(String haystack, String needle) {
		if(haystack.length() < needle.length()) {
			return -1;
		}
		if(needle.length() == 0) {
			return 0;
		}

		int[] next = calcNext(needle);
		int i = 0, j = 0;
		while(i < haystack.length() && j < needle.length()) {
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == needle.length() ? i - j : -1;
	}

	/**
	 * 计算next数组
	 * @param s s
	 * @return next
	 */
	public int[] calcNext(String s) {
		char[] chars = s.toCharArray();
		int[] next = new int[s.length()];
		next[0] = -1;

		int i = 0,j = -1;
		while(i < s.length() - 1) {
			if(j == -1 || chars[i] == chars[j]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
}
