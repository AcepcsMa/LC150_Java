package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #74
 * Search a 2D Matrix
 */
public class Search2DMatrix {

	public static void main(String[] args) {
		Search2DMatrix solution = new Search2DMatrix();
	}

	/**
	 * 思路: 将二维数组看作是一维数组, 在一维数组上应用二分查找。
	 * @param matrix matrix
	 * @param target target
	 * @return true/false
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		int row = matrix.length, col = matrix[0].length;
		int lower = 0, upper = row * col - 1;

		while(lower <= upper) {
			int mid = (lower + upper) / 2;
			int midValue = matrix[mid / col][mid % col];	// 二维映射到一维
			if(midValue == target) {
				return true;
			} else if(midValue < target) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
		return false;
	}
}
