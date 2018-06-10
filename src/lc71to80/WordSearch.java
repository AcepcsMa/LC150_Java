package lc71to80;

/**
 * @author Haoxiang Ma
 * Leetcode #79
 * Word Search
 */
public class WordSearch {

	public static void main(String[] args) {
		WordSearch solution = new WordSearch();
	}

	/**
	 * 思路: DFS。
	 * @param board board
	 * @param word word
	 * @return true/false
	 */
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || word == null || word.length() == 0) {
			return false;
		}

		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[i].length;j++) {
				if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, used)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] used) {
		if(index == word.length()) {
			return true;	// 走到最终点, 证明已经找到
		}

		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || index > word.length() || used[row][col]) {
			return false;	// 边界情况
		}

		char cur = word.charAt(index);
		if(board[row][col] != cur) {
			return false;
		}

		// DFS, 进入下一层
		used[row][col] = true;
		if(dfs(board, row + 1, col, word, index + 1, used)
			|| dfs(board, row - 1, col, word, index + 1, used)
			|| dfs(board, row, col + 1, word, index + 1, used)
			|| dfs(board, row, col - 1, word, index + 1, used)) {
			return true;
		}
		used[row][col] = false;
		return false;
	}
}
