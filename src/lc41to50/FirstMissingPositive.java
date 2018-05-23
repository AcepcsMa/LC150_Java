package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #41
 * First Missing Positive
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive solution = new FirstMissingPositive();
	}

	/**
	 * 思路: 既然要找positive number, 又不要求保持原数组的数据完整性, 那我们可以
	 * 把数组内的正数i+1放到i位置去, 例如0号位置放数字1, 5号位置放数字6。 最后再从头
	 * 开始遍历, 若i位置对应的数字不是i+1, 就找到了缺失的first positive number。
	 * @param nums nums
	 * @return num
	 */
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] > 0 && nums[i] <= nums.length && i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);	// 如果i位置的数不是i+1, swap
			} else {
				i++; // 否则继续遍历
			}
		}
		for(i = 0;i < nums.length;i++) {
			if(i + 1 != nums[i]) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
