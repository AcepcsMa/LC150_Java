package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #73
 * Set Matrix Zeroes
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes solution = new SetMatrixZeroes();
	}

	/**
	 * 用首行和首列来记录该行/列是否需要置零。如果在遍历的过程中发现m[i][j] == 0,
	 * 则将m[i][j]所在行&列的首个位置置零。最后再检查首行&列的置零情况, 给对应的
	 * 行&列置零。
	 * @param matrix matrix
	 */
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return;
		}

		boolean firstRow = false, firstCol = false;
		for(int i = 0;i < matrix.length;i++) {
			for(int j = 0;j < matrix[i].length;j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;	// 遍历矩阵, 遇到0就将该行&列的首位置零
					if(i == 0) {
						firstRow = true;
					}
					if(j == 0) {
						firstCol = true;
					}
				}
			}
		}

		for(int i = 1;i < matrix.length;i++) {
			if(matrix[i][0] == 0) {
				for(int j = 1;j < matrix[i].length;j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for(int j = 1;j < matrix[0].length;j++) {
			if(matrix[0][j] == 0) {
				for(int i = 1;i < matrix.length;i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if(firstRow) {
			for(int j = 0;j < matrix[0].length;j++) {
				matrix[0][j] = 0;
			}
		}

		if(firstCol) {
			for(int i = 0;i < matrix.length;i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
