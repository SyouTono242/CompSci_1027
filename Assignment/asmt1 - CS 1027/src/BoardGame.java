
/**
 * This class BoardGame represents the board where the snake moves around eating apples
 * 
 * @author Yiran Shao
 *
 */
public class BoardGame {
	private int board_length;  // the number of columns of the grid on the game board, initialized as 0
	private int board_width;  // the number of rows of the grid, initialized as 0
	private Snake theSnake;  // an object of the class Snake, representing the playing snake
	private String[][] matrix;  // a 2-dimensional matrix that will store the content of each one of the squares of the grid
	
	/**
	 * The constructor for the file.
	 * 
	 * @param boardFile  the name of a file containing the dimensions of the game board, 
	 * the initial position of the snake, and the objects placed on the game board
	 */
	public BoardGame(String boardFile) {
		int current_row = 0;
		int current_column = 0;
		
		MyFileReader in;
		String fileName = boardFile;
		
		in = new MyFileReader(fileName);
		
			while (in.endOfFile() == false) {
				in.readInt();
				in.readInt();
				board_length = in.readInt(); // store the 3rd number, the length of the board, in board_length
				board_width = in.readInt(); // store the 4th number, the width of the board, in board_width
				current_row = in.readInt(); // store the 5th number, the initial row position, in current_row
				current_column = in.readInt(); // store the 6th number, the initial column position, in current_col
				theSnake = new Snake(current_row, current_column); // create theSnake at the initial position
				matrix = new String[board_width][board_length]; // create a two-dimensional matrix
				
				for (int i = 0; i < board_width; i++) {
		            for (int j = 0; j < board_length; j++) {
		                matrix[i][j] = "empty";
		            }
				}
				
				int counter = 0; // read and store the information in the file, 3 lines in a row
				while (in.endOfFile() == false && counter < 3) {
					int number1 = in.readInt(); // read the row position of the object
					int number2 = in.readInt(); // read the column position of the object
					String string1 = in.readString(); // read the type of the object
					matrix[number1][number2] = string1; // store all those information in the matrix
				}
			}
		}
		
	/**
	 * returns the string stored in matrix[row][col]
	 * 
	 * @param row the row position of the object
	 * @param col the column position of the object
	 * @return the name/type of the object
	 */
	public String getObject(int row, int col) {
		return matrix[row][col];
	}
	
	/**
	 * stores newObject in matrix[row][col]
	 * 
	 * @param row the row position of the new object
	 * @param col the column position of the new object
	 * @param newObject the name/type of the new object
	 */
	public void setObject(int row, int col, String newObject) {
		matrix[row][col] = newObject;
	}
	
	/**
	 * returns theSnake
	 * 
	 * @return the snake
	 */
	public Snake getSnake() {
		return theSnake;
	}
	
	/**
	 * stores the value of newSnake in instance variable theSnake
	 * 
	 * @param newSnake
	 */
	public void setSnake(Snake newSnake) {
		theSnake = newSnake;
	}
	
	/**
	 * returns the length of the game board
	 * 
	 * @return the length of the game board
	 */
	public int getLength() {
		return board_length;
	}
	
	/**
	 * returns the width of the game board
	 * 
	 * @return the width of the game board
	 */
	public int getWidth() {
		return board_width;
	}
	
	/**
	 * returns the name/type of the object stored in the given position of the matrix
	 * 
	 * @param row the row position of the object
	 * @param col the column position of the object
	 * @return the name/type of the object
	 */
	public String getType(int row, int col) {
		return matrix[row][col];
	}
}


