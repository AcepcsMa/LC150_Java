package lc11to20;

/**
 * @author Haoxiang Ma
 * Leetcode #11
 * Container With Most Water
 */
public class Container {

	public static void main(String[] args) {
		Container solution = new Container();
	}

	/**
	 * 思路: 面积 = 底长 * 高度, 要求最大面积即要求出最优的底长&高度的组合。
	 * 所以可以设置左右双指针, 从最长的底长开始尝试(0 - len), 然后逐渐缩小,
	 * 找出最优组合。
	 * @param height height
	 * @return max
	 */
	public int maxArea(int[] height) {
		if(height == null || height.length == 0) {
			return 0;
		}

		int left = 0, right = height.length - 1;
		int max = 0;

		while(left < right) {
			int bottom = right - left;
			int h = Math.min(height[left], height[right]);
			max = Math.max(max, bottom * h);

			// 哪条边短就挪哪条边, 因为高度取决于两边中的短边, 为了真正的高度更高
			// 就要找到更高的"短边"
			if(height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
