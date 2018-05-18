package lc31to40;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Haoxiang Ma
 * Leetcode #36
 * Valid Sudoku
 */
public class ValidSudoku {

	public static void main(String[] args) {
		ValidSudoku solution = new ValidSudoku();
	}

	/**
	 * 思路: 要从3个方面检查一个9*9的数独矩阵是否valid, 每行&每列&每个九宫格。
	 * 利用HashSet来存储每行/每列/每个九宫格内的元素, 从而判断是否重复。
	 * @param board board
	 * @return true/false
	 */
	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) {
			return false;	// 确保是一个9*9的数独矩阵
		}

		int cubeCount = 9;	// 有9个小的九宫格
		int elemCount = 9;	// 每个小的九宫格里有9个元素

		// 检查每个小的九宫格
		for(int i = 0;i < cubeCount;i++) {
			Set<Character> cube = new HashSet<>();
			Set<Character> row = new HashSet<>();
			Set<Character> col = new HashSet<>();

			// 检查小九宫格里的每个元素, 顺便检查某列和某行的元素
			for(int j = 0;j < elemCount;j++) {
				if(board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if(board[j][i] != '.' && !col.add(board[j][i])) {
					return false;
				}
				int startRow = (i / 3) * 3;	// 对i号九宫格而言, 起始横坐标是(i/3)*3
				int startCol = (i % 3) * 3;	// 对i号九宫格而言, 起始纵坐标是(i%3)*3
				if(board[startRow + j / 3][startCol + j % 3] != '.' && !cube.add(board[startRow + j / 3][startCol + j % 3])) {
					return false;
				}
			}
		}
		return true;
	}
}
