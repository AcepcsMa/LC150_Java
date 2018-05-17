package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #34
 * Search for a Range
 */
public class SearchForRange {

	public static void main(String[] args) {
		SearchForRange solution = new SearchForRange();
	}

	/**
	 * 思路: 原数组是sorted array, 所以可以应用二分查找。跟传统的二分
	 * 查找不一样的是, 我们可以指定查找第一次出现的index和最后一次出现的
	 * index。当求最后一次出现的index时, 一旦我们找到了目标数字, 仍不return,
	 * 继续向后找。
	 * @param nums nums
	 * @param target target
	 * @return indices
	 */
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}

		int first = binarySearch(nums, 0, nums.length - 1, target, -1, true);
		int second = binarySearch(nums, 0, nums.length - 1, target, -1, false);
		return new int[]{first, second};
	}

	/**
	 * 二分查找, 多设置了一个result用来保存查找结果, 还有一个布尔变量
	 * findFirst用来表示本次查找是否要查找第一次出现的index。
	 * @param nums nums
	 * @param lower lower
	 * @param upper upper
	 * @param target target
	 * @param result result
	 * @param findFirst if find first index
	 * @return index
	 */
	public int binarySearch(int[] nums, int lower, int upper, int target, int result, boolean findFirst) {
		if(lower > upper) {
			return result;
		}

		int mid = (lower + upper) / 2;
		if(nums[mid] == target) {
			result = mid;
		}

		if(nums[mid] < target || (nums[mid] == target && findFirst == false)) {
			return binarySearch(nums, mid + 1, upper, target, result, findFirst);
		} else {
			return binarySearch(nums, lower, mid - 1, target, result, findFirst);
		}
	}
}
