package lc41to50;

/**
 * @author Haoxiang Ma
 * Leetcode #48
 * Rotate Image
 */
public class RotateImage {

	public static void main(String[] args) {
		RotateImage solution = new RotateImage();
	}

	/**
	 * 思路: 顺时针旋转90度 = 先转置 + 后逐行reverse。
	 * @param matrix matrix
	 */
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			return;
		}

		// 转置矩阵
		for(int i = 0;i < matrix.length;i++) {
			for(int j = 0;j < i;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// 逐行reverse
		for(int i = 0;i < matrix.length;i++) {
			int head = 0, tail = matrix[i].length - 1;
			while(head < tail) {
				int temp = matrix[i][head];
				matrix[i][head] = matrix[i][tail];
				matrix[i][tail] = temp;
				head++;
				tail--;
			}
		}
	}
}
