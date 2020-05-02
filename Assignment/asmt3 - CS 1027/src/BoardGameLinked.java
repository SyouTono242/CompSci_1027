
/**
 * This class represents the board game where the snake moves around eating apples.
 * 
 * @author Yiran Shao
 *
 */
public class BoardGameLinked {
	int boardLength;				// The number of columns of the grid on the game board
	int boardWidth;					// The number of rows of the grid
	SnakeLinked theSnake;			// An object of the class SnakeLinked representing the snake
	DoubleList<String>[] board;		// An array of doubly linked lists
	
	
	/**
	 * The constructor of the file. 
	 * 
	 * @param boardFile the name of a file containing the dimensions of the game board, the initial 
	 * position of the snake, and the objects placed on the game board
	 */
	@SuppressWarnings("unchecked")
	public BoardGameLinked(String boardFile){
		int currentRow;
		int currentColumn;
		
		MyFileReader in;
		String fileName = boardFile;
		
		in = new MyFileReader(fileName);
		
		while (in.endOfFile() == false) {
			in.readInt();
			in.readInt();
			boardLength = in.readInt(); 	// store the 3rd number, the length of the board, in boardLength
			boardWidth = in.readInt(); 		// store the 4th number, the width of the board, in boardWidth
			currentRow = in.readInt(); 		// store the 5th number, the initial row position, in currentRow
			currentColumn = in.readInt(); 	// store the 6th number, the initial column position, in currentCol
			
			theSnake = new SnakeLinked(currentRow, currentColumn);
			board = (DoubleList<String>[]) new DoubleList[boardWidth];
			
			for (int i = 0; i < boardWidth; i++){		// initialize every cell to be "empty"
				board[i] = new DoubleList<String>();
				for (int j = 0; j < boardLength; j++) {
					board[i].addData(0, "empty");
				}
			}
			
			while(in.endOfFile() == false) {
				int objRow = in.readInt(); 			// read the row position of the object
				int objCol = in.readInt(); 			// read the column position of the object
				String obj = in.readString(); 		// read the type of the object
				board[objRow].setData(objCol,obj);	// set the object at its position
			}
		}
	}
	
	/**
	 * returns the string stored in the node with index = col of the doubly linked list referenced by board[row]
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws InvalidPositionException if row or col are negative, if row ≥ boardWidth, or if col ≥ boardLength
	 */
	public String getObject(int row, int col) throws InvalidPositionException{
		if ((row < 0 || col < 0)||(row >= boardWidth || col >= boardLength)) {
			throw new InvalidPositionException("Index out of range.");
		}
		else {
			String obj = board[row].getData(col);
			return obj;
		}
	}
	
	/**
	 * stores newObject in the node with index = col of the doubly linked list referenced by board[row]
	 * 
	 * @param row
	 * @param col
	 * @param newObject
	 * @throws InvalidPositionException  if row or col are negative, if row ≥ boardWidth, or if col ≥ boardLength
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException{
		if ((row < 0 || col < 0)||(row >= boardWidth || col >= boardLength)) {
			throw new InvalidPositionException("Index out of range.");
		}
		else {
			board[row].setData(col, newObject);
		}
	}
	
	/**
	 * returns theSnake
	 * 
	 * @return
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
	/**
	 * stores the value of newSnake in instance variable theSnake
	 * 
	 * @param newSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	
	/**
	 * returns boardLength
	 * 
	 * @return
	 */
	public int getLength() {
		return boardLength;
	}
	
	/**
	 * returns boardWidth
	 * 
	 * @return
	 */
	public int getWidth() {
		return boardWidth;
	}
}
