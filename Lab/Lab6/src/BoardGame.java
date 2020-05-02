public class BoardGame {
	private String[][] matrix = {
			{ "empty", "empty", "apple", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "rock", "empty", "apple", "empty", "empty", "empty", "empty", "empty", "apple", "empty", "empty",
					"empty", "empty", "empty" },
			{ "scissors", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "empty", "empty", "empty", "apple", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" },
			{ "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty",
					"empty", "empty", "empty", "empty" } };
	private int board_length = 15, board_width = 8;
	private Snake theSnake;

	public BoardGame(String boardFile) {
		theSnake = new Snake(5, 8);
	}

	public void setObject(int row, int col, String newObject) {
		matrix[row][col] = newObject;
	}

	public String getObject(int row, int col) {
		return matrix[row][col];
	}

	public Snake getSnake() {
		return theSnake;
	}

	public int getLength() {
		return board_length;
	}

	public int getWidth() {
		return board_width;
	}

	public String getType(int row, int col) {
		return matrix[row][col];
	}
}