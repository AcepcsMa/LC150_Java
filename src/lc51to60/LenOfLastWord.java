package lc51to60;

/**
 * @author Haoxiang Ma
 * Leetcode #58
 * Length of Last Word
 */
public class LenOfLastWord {

	public static void main(String[] args) {
		LenOfLastWord solution = new LenOfLastWord();
	}

	/**
	 * 思路: 从右到左遍历, 先跳过非字母的字符, 从第一个字母字符开始数。
	 * @param s s
	 * @return length
	 */
	public int lengthOfLastWord(String s) {
		int index = s.length() - 1;
		int length = 0;
		while(index >= 0 && s.charAt(index) == ' ') {
			index--;	// 先跳过空格
		}
		while(index >= 0 && s.charAt(index) != ' ') {
			length++;
			index--;
		}
		return length;
	}
}
