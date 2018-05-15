package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #26
 * Remove Duplicates from Sorted Array
 */
public class RemoveDup {

	public static void main(String[] args) {
		RemoveDup solution = new RemoveDup();
	}

	/**
	 * 思路: two pointer。
	 * @param nums nums
	 * @return length
	 */
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0, right = 0;
		while(right < nums.length) {
			while(right < nums.length && nums[right] == nums[left]) {
				right++;	// 直到右指针找到不同的元素
			}
			if(right < nums.length) {
				nums[++left] = nums[right];
			}
		}
		return left + 1;
	}
}
