package lc51to60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #54
 * Spiral Matrix
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix solution = new SpiralMatrix();
	}

	/**
	 * 思路: 记录startRow, startCol, endRow, endCol, 沿着螺旋式的路线一直遍历。
	 * @param matrix matrix
	 * @return result
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix == null || matrix.length == 0) {
			return result;
		}

		int startRow = 0, startCol = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;
		while(startRow <= endRow && startCol <= endCol) {
			for(int i = startCol;i <= endCol;i++) {
				result.add(matrix[startRow][i]);	// 左 -> 右
			}
			startRow++;

			for(int i = startRow;i <= endRow;i++) {
				result.add(matrix[i][endCol]);	// 上 -> 下
			}
			endCol--;

			if(startRow <= endRow) {
				for(int i = endCol;i >= startCol;i--) {
					result.add(matrix[endRow][i]);	// 右 -> 左
				}
				endRow--;
			}

			if(startCol <= endCol) {
				for(int i = endRow;i >= startRow;i--) {
					result.add(matrix[i][startCol]);	// 下 -> 上
				}
				startCol++;
			}
		}
		return result;
	}
}
