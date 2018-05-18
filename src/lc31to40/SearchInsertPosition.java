package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #35
 * Search Insert Position
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition solution = new SearchInsertPosition();
	}

	/**
	 * 思路: 直接二分查找。
	 * @param nums nums
	 * @param target target
	 * @return index
	 */
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}

		int lower = 0, upper = nums.length - 1;
		while(lower <= upper) {
			int mid = (lower + upper) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
		return lower;
	}
}
