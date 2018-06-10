package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #80
 * Remove Duplicates from Sorted Array II
 */
public class RmDupFromSortedArrII {

	public static void main(String[] args) {
		RmDupFromSortedArrII solution = new RmDupFromSortedArrII();
	}

	/**
	 * 思路: 类似two pointer的思想。从左到右遍历过程中保持一个左指针,
	 * 左指针指向下一个数应放置的位置。
	 * @param nums nums
	 * @return number of result
	 */
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int index = 0;
		for(int num : nums) {
			if(index < 2 || num != nums[index - 2]) {
				nums[index++] = num;
			}
		}
		return index;
	}
}
