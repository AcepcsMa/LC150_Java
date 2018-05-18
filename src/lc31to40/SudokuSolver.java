package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #37
 * Sudoku Solver
 */
public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver solution = new SudokuSolver();
	}

	/**
	 * 思路: 利用DFS的思想, 一直尝试下去, 直到所有未填的空格都被正确填充。
	 * @param board board
	 */
	public void solveSudoku(char[][] board) {
		dfs(board);
	}

	/**
	 * DFS
	 * @param board board
	 * @return true/false
	 */
	public boolean dfs(char[][] board) {
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(board[i][j] == '.') {
					for(char ch = '1';ch <= '9';ch++) {
						if(isValid(board, i, j, ch)) {	// 如果在(i,j)处填入ch合法, 继续DFS下去
							board[i][j] = ch;
							if(dfs(board)) {
								return true;	// 如果下层也成功填充就返回true
							} else {
								board[i][j] = '.';	// 否则就回溯
							}
						}
					}
					return false;	// 1-9没有一个成功的就返回false
				}
			}
		}
		return true;
	}

	/**
	 * 检查在(row, col)处填入ch是否合法
	 * @param board board
	 * @param row row
	 * @param col col
	 * @param ch ch
	 * @return true/false
	 */
	public boolean isValid(char[][] board, int row, int col, char ch) {
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for(int i = 0;i < 9;i++) {
			if(board[row][i] == ch || board[i][col] == ch) {
				return false;
			}
			if(board[startRow + i / 3][startCol + i % 3] == ch) {
				return false;
			}
		}
		return true;
	}
}
