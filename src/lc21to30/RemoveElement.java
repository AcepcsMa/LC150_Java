package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #27
 * Remove Element
 */
public class RemoveElement {

	public static void main(String[] args) {
		RemoveElement solution = new RemoveElement();
	}

	/**
	 * 思路: two pointer。右指针一直向右移动, 遇到不等于val的元素就放到左指针
	 * 所在的位置, 左指针+1; 遇到等于val的元素就继续移动。
	 * @param nums nums
	 * @param val val
	 * @return length
	 */
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0, right = 0;
		while(right < nums.length) {
			if(nums[right] != val) {
				nums[left++] = nums[right];
			}
			right++;
		}
		return left;
	}
}
