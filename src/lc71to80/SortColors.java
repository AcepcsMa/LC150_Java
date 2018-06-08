package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #75
 * Sort Colors
 */
public class SortColors {

	public static void main(String[] args) {
		SortColors solution = new SortColors();
	}

	/**
	 * 思路: 记录0, 1, 2的个数。根据各个数字的个数重新放置到数组中。
	 * @param nums nums
	 */
	public void sortColors(int[] nums) {
		int zero = 0, one = 0, two = 0;

		// 记录0, 1, 2的个数
		for(int num : nums) {
			if(num == 0) {
				zero++;
			} else if(num == 1) {
				one++;
			} else {
				two++;
			}
		}

		// 根据0, 1, 2的个数从左到右放置
		for(int i = 0;i < nums.length;i++) {
			if(i < zero) {
				nums[i] = 0;
			} else if(i >= zero && i < zero + one) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}
	}
}
