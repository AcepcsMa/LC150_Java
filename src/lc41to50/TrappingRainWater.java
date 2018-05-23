package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #42
 * Trapping Rain Water
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater solution = new TrappingRainWater();
	}

	/**
	 * 思路: 维护一个leftMax和一个rightMax, 分别从左到右遍历和从右到左遍历。
	 * 遇到比leftMax/rightMax小的, 说明该处可以蓄水, 该处的差值即为可蓄水的容量。
	 * @param height height
	 * @return volume
	 */
	public int trap(int[] height) {
		if(height == null || height.length == 0) {
			return 0;
		}

		int volume = 0;
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[0];
		int rightMax = height[height.length - 1];

		while(left <= right) {
			if(height[left] <= height[right]) {
				leftMax = Math.max(leftMax, height[left]);
				volume += (leftMax - height[left]);
				left++;
			} else {
				rightMax = Math.max(rightMax, height[right]);
				volume += (rightMax - height[right]);
				right--;
			}
		}
		return volume;
	}
}
