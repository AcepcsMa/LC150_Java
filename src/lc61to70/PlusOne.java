package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #66
 * Plus One
 */
public class PlusOne {

	public static void main(String[] args) {
		PlusOne solution = new PlusOne();
	}

	/**
	 * 思路: 加法要从最低位开始加, 所以要从右往左遍历。 在遍历过程中,
	 * 如果遇到小于9的数, 直接让其加一然后返回; 如果遇到等于9的数, 让
	 * 其置零(相当于+1后然后当前位置变为0), 继续向左遍历。
	 * @param digits digits
	 * @return result
	 */
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) {
			return digits;
		}

		for(int i = digits.length - 1;i >= 0;i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;	// 小于9的数无需进位, 自增后返回
			} else {
				digits[i] = 0;	// 等于9的数需要变为0, 然后继续向左走
			}
		}

		// 如果走到了这一步, 说明前面的全是9 -> 0, 最高位需要多进一位
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}
