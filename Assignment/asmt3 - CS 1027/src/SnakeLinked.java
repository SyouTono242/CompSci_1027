
/**
 * The class stores the information about the snake as it moves around the board.
 * 
 * @author Yiran Shao
 *
 */
public class SnakeLinked {
	int snakeLength;					// The number of tiles of the game board occupied by the snake
	DoubleList<Position> snakeBody;		// The list that stores the positions of the tiles of the game board occupied by the snake
	
	/**
	 * The constructor of the class.
	 * 
	 * @param row the row of the head of the snake
	 * @param col the column of the head of the snake
	 */
	public SnakeLinked(int row, int col) {
			snakeLength = 1;
			Position headPosition = new Position(row, col);
			snakeBody = new DoubleList<Position>();
			snakeBody.addData(0, headPosition);	
	}
	
	/**
	 * returns the value of instance variable snakeLength
	 * @return snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * returns the Position object stored in the node of the doubly linked list with the given index
	 * 
	 * @param index 
	 * @return
	 */
	public Position getPosition(int index) {
		if (index < 0 || index >= snakeLength) {
			return null;
		}
		else {
			return snakeBody.getData(index);
		}
	}
	
	/**
	 * returns true if pos is in the doubly linked list of snakeBody, and returns false otherwise
	 * @param pos
	 * @return
	 */
	public boolean snakePosition(Position pos) {
		Boolean positionFound = false;
		Position currentPos;
		for (int i=0; i<=snakeLength-1; i++) {
			currentPos = snakeBody.getData(i);
			if (currentPos.equals(pos)) {
				positionFound = true;
			}
		}
		return positionFound;
	}
	
	/**
	 * returns the new position that the head of the snake would occupy if the snake moved in the direction specified by the parameter
	 * 
	 * @param direction
	 * @return
	 */
	public Position newHeadPosition(String direction) {
		Position headPos = new Position(0,0);
		headPos.setRow(snakeBody.getData(0).getRow());
		headPos.setCol(snakeBody.getData(0).getCol());
		int row = headPos.getRow();
		int col = headPos.getCol();
		if (direction.equals("right")) {
			headPos.setCol(col+1);
		}
		else if (direction.equals("left")) {
			headPos.setCol(col-1);
		}
		else if(direction.equals("up")) {
			headPos.setRow(row-1);
		}
		else if(direction.equals("down")) {
			headPos.setRow(row+1);
		}
		return headPos;
	}
	
	/**
	 * moves the snake in the specified direction
	 * 
	 * @param direction
	 */
	public void moveSnakeLinked(String direction) {
		snakeBody.addData(0, newHeadPosition(direction));
		snakeBody.removeData(snakeLength);
	}
	
	/**
	 * decreases the value of snakeLength by 1 and deletes the last node in the doubly linked list of snakeBody
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength-1);
		snakeLength--;
	}
	
	/**
	 * increases the length of the snake by 1 and moves the snake’s head in the direction specified
	 * @param direction
	 */
	public void grow(String direction) {
		snakeBody.addData(0, newHeadPosition(direction));
		snakeLength++;
	}
}
