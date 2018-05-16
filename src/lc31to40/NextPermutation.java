package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #31
 * Next Permutation
 */
public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation solution = new NextPermutation();
	}

	/**
	 * 思路: 从后往前遍历, 找到第一个数nums[i] < nums[i+1], 然后再从后往前遍历
	 * 找到第一个比nums[i]大的数nums[j], 把nums[i]和nums[j]交换, 再对i后面的数
	 * 进行reverse, 就得到了答案。
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}

		int i = nums.length - 2;
		while(i >= 0 && nums[i] >= nums[i + 1]) {
			i--;	// 从后往前找到第一个nums[i] < nums[i+1]
		}
		if(i >= 0) {
			int j = nums.length - 1;
			while(j > i && nums[j] <= nums[i]) {
				j--;	// 从后往前找到第一个nums[j] > nums[i]
			}
			if(j > i) {
				// 交换后将i后面的数字reverse
				swap(nums, i, j);
				reverse(nums, i + 1, nums.length - 1);
			}
		} else {
			// 如果找不到任何一个nums[i] < nums[i+1], 只能全部reverse
			reverse(nums, 0, nums.length - 1);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
