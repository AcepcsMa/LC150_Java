package lc1to10;

/**
 * @author Haoxiang Ma
 * Leetcode #4
 * Median of Two Sorted Arrays
 */
public class MedianOfSortedArr {

	public static void main(String[] args) {
		MedianOfSortedArr solution = new MedianOfSortedArr();
	}

	/**
	 * 思路: 找到2个cut的位置，使得cut的左半部分和cut的右半部分正好平分数组,
	 * 所以cut位置的两边的平均值就是中位数
	 * @param nums1 nums1
	 * @param nums2 nums2
	 * @return median
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1 < len2) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int lower = 0;
		int upper = 2 * len2;
		while(lower <= upper) {
			// 算出当前cut的位置
			int mid2 = (lower + upper) / 2;
			int mid1 = len1 + len2 - mid2;

			// 找到当前cut两边的数
			double L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			double R1 = mid1 == 2 * len1 ? Integer.MAX_VALUE : nums1[mid1 / 2];
			double L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double R2 = mid2 == 2 * len2 ? Integer.MAX_VALUE : nums2[mid2 / 2];

			// L必须要小于R
			if(L1 > R2) {
				lower = mid2 + 1;
			} else if(L2 > R1) {
				upper = mid2 - 1;
			} else {
				return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
			}
		}
		return -1.0;
	}
}
