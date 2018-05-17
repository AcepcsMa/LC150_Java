package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #33
 * Search in Rotated Sorted Array
 */
public class SearchRotatedSortedArr {

	public static void main(String[] args) {
		SearchRotatedSortedArr solution = new SearchRotatedSortedArr();
	}

	/**
	 * 思路: 修改版的二分查找。因为是sorted array, 所以即使它被旋转了, 仍然
	 * 存在一部分是有序的, 可以先定位有序的部分, 然后判断target是否在有序部分内,
	 * 再进行二分查找。
	 * @param nums nums
	 * @param target target
	 * @return index
	 */
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}

		int lower = 0;
		int upper = nums.length - 1;
		while(lower <= upper) {
			int mid = (lower + upper) / 2;
			if(nums[mid] == target) {
				return mid;
			}

			// 确定[lower, mid]是有序的还是[mid, upper]是有序的, 只能在有序区间内二分查找
			if(nums[lower] <= nums[mid]) {
				if(target >= nums[lower] && target <= nums[mid]) {
					upper = mid - 1;
				} else {
					lower = mid + 1;
				}
			}
			if(nums[mid] <= nums[upper]) {
				if(target >= nums[mid] && target <= nums[upper]) {
					lower = mid + 1;
				} else {
					upper = mid - 1;
				}
			}
		}
		return -1;
	}
}
