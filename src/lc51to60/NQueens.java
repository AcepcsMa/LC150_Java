package lc51to60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #51
 * N-Queens
 */
public class NQueens {

	public static void main(String[] args) {
		NQueens solution = new NQueens();
	}

	/**
	 * 思路: 用DFS进行棋盘填充。
	 * @param n n
	 * @return n queens
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if(n <= 0) {
			return result;
		}
		char[][] board = new char[n][n];
		for(int i = 0;i < board.length;i++) {
			Arrays.fill(board[i], '.');
		}
		dfs(result, board, 0);
		return result;
	}

	public void dfs(List<List<String>> result, char[][] board, int col) {
		if(col == board[0].length) {
			result.add(transform(board));
		} else {
			for(int i = 0;i < board.length;i++) {
				if(isValid(board, i, col)) {	// 如果当前坐标可放皇后则放置, 然后继续DFS
					board[i][col] = 'Q';
					dfs(result, board, col + 1);
					board[i][col] = '.';
				}
			}
		}
	}

	public boolean isValid(char[][] board, int row, int col) {
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < col;j++) {
				if(i == row && board[i][j] != '.') {
					return false;	// 同一行已放皇后
				}
				if(board[i][j] != '.' && Math.abs(i - row) == Math.abs(j - col)) {
					return false;	// 对角线已放皇后
				}
			}
		}
		return true;
	}

	public List<String> transform(char[][] board) {
		List<String> result = new ArrayList<>();
		for(int i = 0;i < board.length;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j < board[i].length;j++) {
				sb.append(board[i][j]);
			}
			result.add(sb.toString());
		}
		return result;
	}
}
