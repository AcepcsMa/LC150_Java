package lc51to60;

import java.util.Arrays;

/**
 * @author Haoxiang Ma
 * Leetcode #52
 * N-Queens II
 */
public class NQueensII {

	public static void main(String[] args) {
		NQueensII solution = new NQueensII();
	}

	/**
	 * 思路: 利用DFS来进行填充计数。用一维数组来代替N-Queens里面的二维棋盘, 以优化算法复杂度。
	 * 如果board[row][col]可放置一个皇后, 那么就等价于board[col] = row;
	 * 如果board[row][col]不可放皇后, 那么board[col] = -1。
	 * @param n n
	 * @return number of solutions
	 */
	public int totalNQueens(int n) {
		if(n <= 0) {
			return 0;
		}
		int[] result = new int[]{0};
		int[] board = new int[n];
		Arrays.fill(board, - 1);
		dfs(result, board, 0);
		return result[0];
	}

	public void dfs(int[] result, int[] board, int col) {
		if(col == board.length) {
			result[0]++;
		} else {
			for(int i = 0;i < board.length;i++) {
				if(isValid(board, i, col)) {
					board[col] = i;
					dfs(result, board, col + 1);
					board[col] = -1;
				}
			}
		}
	}

	public boolean isValid(int[] board, int row, int col) {
		for(int i = 0;i < col;i++) {
			if(board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
				return false;	// 如果同一行或者对角线上已经放了皇后, 不可再放
			}
		}
		return true;
	}
}
