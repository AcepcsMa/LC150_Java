package lc51to60;

/**
 * @author Haoxiang Ma
 * Leetcode #59
 * Spiral Matrix II
 */
public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII solution = new SpiralMatrixII();
	}

	/**
	 * 思路: 相当于螺旋式遍历二维矩阵。
	 * @param n n
	 * @return matrix
	 */
	public int[][] generateMatrix(int n) {
		if(n <= 0) {
			return null;
		}

		int startRow = 0, startCol = 0, endRow = n - 1, endCol = n - 1;
		int num = 1;
		int[][] matrix = new int[n][n];

		while(startRow <= endRow && startCol <= endCol) {
			for(int i = startCol;i <= endCol;i++) {
				matrix[startRow][i] = num++;	// 从左到右
			}
			startRow++;

			for(int i = startRow;i <= endRow;i++) {
				matrix[i][endCol] = num++;	// 从上到下
			}
			endCol--;

			if(startRow <= endRow) {
				for(int i = endCol;i >= startCol;i--) {
					matrix[endRow][i] = num++;	// 从右到左
				}
				endRow--;
			}

			if(startCol <= endCol) {
				for(int i = endRow;i >= startRow;i--) {
					matrix[i][startCol] = num++;	// 从下到上
				}
				startCol++;
			}
		}
		return matrix;
	}
}
