package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #43
 * Multiply Strings
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings solution = new MultiplyStrings();
	}

	/**
	 * 思路: 小学乘法， 竖式计算， 然后将各中间结果加起来。
	 * @param num1 num1 num1
	 * @param num2 num2 num2
	 * @return result result
	 */
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1 + len2];	// 相乘的结果最多是len1 + len2位

		for(int i = num1.length() - 1;i >= 0;i--) {
			for(int j = num2.length() - 1;j >= 0;j--) {
				int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				temp = temp + result[i + j + 1];	// 相乘后加上进位
				result[i + j] += temp / 10;
				result[i + j + 1] = temp % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int digit : result) {
			if(sb.length() == 0 && digit == 0) {
				continue;
			}
			sb.append(digit);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
