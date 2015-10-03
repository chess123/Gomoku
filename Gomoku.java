public class Gomoku {

	public static void main(String[] args) {
		int size = Prompt.getInt("Enter a board size (minimum 5) -> ", 5, Integer.MAX_VALUE);
		int[][] board = new int[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		boolean black = false;
		int x, y;
		do {
			black = !black;
			printOut(board);
			do {
				x = Prompt.getInt("\nEnter an x-coordinate: ", 1, board[0].length);
				y = Prompt.getInt("\nEnter an y-coordinate: ", 1, board.length);
				int temp = x;
				x = board.length - y + 1;
				y = temp;
			} while (board[x - 1][y - 1] != 0);
			System.out.println();
			if (black) board[x - 1][y - 1] = -1;
			else board[x - 1][y - 1] = 1;
		} while (!fiveInARow(board, x - 1, y - 1, black));
		if (black) System.out.println("\nCongratulations, black: YOU WIN!");
		else System.out.println("\nCongratulations, white: YOU WIN!");
	}

	public static boolean fiveInARow(int[][] board, int x, int y, boolean black) {
		if (black) {
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || board[x - i][y] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x + i >= board[x].length || board[x + i][y] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y - i < 0 || board[x][y - i] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y + i >= board.length || board[x][y + i] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || y - i < 0 || board[x - i][y - i] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x + i >= board[x].length || y + i >= board.length || board[x + i][y + i] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y - i < 0 || x + i >= board[x].length || board[x + i][y - i] != -1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || y + i >= board.length || board[x - i][y + i] != -1) {
					return false;
				}
			}
			return true;
		}
		else {
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || board[x - i][y] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x + i >= board[x].length || board[x + i][y] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y - i < 0 || board[x][y - i] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y + i >= board.length || board[x][y + i] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || y - i < 0 || board[x - i][y - i] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x + i >= board[x].length || y + i >= board.length || board[x + i][y + i] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (y - i < 0 || x + i >= board[x].length || board[x + i][y - i] != 1) {
					break;
				}
				if (i == 4) return true;
			}
			for (int i = 1; i < 5; i++) {
				if (x - i < 0 || y + i >= board.length || board[x - i][y + i] != 1) {
					return false;
				}
			}
			return true;
		}
	}

	public static void printOut(int[][] board) {
		int cnt = 0;
		for (int[] row : board) {
			cnt++;
			System.out.print((board.length - cnt + 1) % 10 + " ");
			for (int i : row) {
				switch (i) {
					case -1: System.out.print("O "); break;
					case 0: System.out.print("- "); break;
					case 1: System.out.print("X "); break;
				}
			}
			System.out.println();
		}
		System.out.print("  ");
		for (int i = 1; i < board.length + 1; i++) {
			System.out.print(i % 10 + " ");
		}
	}
}