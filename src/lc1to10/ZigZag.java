package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #6
 * ZigZag Conversion
 */
public class ZigZag {

	public static void main(String[] args) {
		ZigZag solution = new ZigZag();
	}

	/**
	 * 思路: 对于每一行建立一个StringBuilder, 然后遍历原始字符串,
	 * 按照规则往正确的StringBuilder里插入对应的字符, 最后再把所有
	 * StringBuilder拼接起来
	 * @param s s
	 * @param numRows numRows
	 * @return String
	 */
	public String convert(String s, int numRows) {
		StringBuilder[] sbs = new StringBuilder[numRows];
		for(int i = 0;i < sbs.length;i++) {
			sbs[i] = new StringBuilder();	// 为每行建立一个StringBuilder
		}

		int index = 0;
		while(index < s.length()) {
			for(int i = 0;index < s.length() && i < numRows;i++) {
				sbs[i].append(s.charAt(index++));	// 对于每一列，从上到下
			}
			for(int i = numRows - 2;index < s.length() && i > 0;i--) {
				sbs[i].append(s.charAt(index++));	// 对于每一斜列，从下到上
			}
		}

		StringBuilder result = new StringBuilder();
		for(StringBuilder sb : sbs) {
			result.append(sb);
		}
		return result.toString();
	}
}
