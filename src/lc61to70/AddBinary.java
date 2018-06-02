package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #67
 * Add Binary
 */
public class AddBinary {

	public static void main(String[] args) {
		AddBinary solution = new AddBinary();
	}

	/**
	 * 思路: 从右向左遍历, 相加, 考虑进位。
	 * @param a a
	 * @param b b
	 * @return result
	 */
	public String addBinary(String a, String b) {
		int len1 = a.length() - 1, len2 = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();

		while(len1 >= 0 || len2 >= 0) {
			int temp = 0;
			if(len1 >=0 && len2 >= 0) {
				temp = (a.charAt(len1) - '0') + (b.charAt(len2) - '0') + carry;
			} else if(len1 >= 0) {
				temp = (a.charAt(len1) - '0') + carry;
			} else if(len2 >= 0) {
				temp = (b.charAt(len2) - '0') + carry;
			}
			sb.append(temp % 2);
			carry = temp / 2;
			if(len1 >= 0) {
				len1--;
			}
			if(len2 >= 0) {
				len2--;
			}
		}
		if(carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
