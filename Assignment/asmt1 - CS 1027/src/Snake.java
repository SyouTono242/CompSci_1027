
/**
 * This class stores the information about the snake as it moves around the board
 * 
 * @author Yiran Shao
 *
 */

public class Snake {
	private int snakeLength; // store the length of the snake
	private Position[] snakeBody; // store the grid squares occupied by the snake in an array
	
	/**
	 * the constructor for the class
	 * 
	 * @param row the row position of the head of the snake
	 * @param col the column position of the head of the snake
	 */
	public Snake(int row, int col) {
		snakeLength = 1; // initialize the length of the snake to be 1
		snakeBody = new Position[5]; // initialize the length of the snake to be 4 (5-1)
		Position snakeHead = new Position(row,col); // a position object that stores the position of the head
		snakeBody[0] = snakeHead; // store the snakeHead in the first entry of the array snakeBody
	}
	
	/**
	 * returns the length of the snake
	 * 
	 * @return the value of instance variable snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * returns the position of the input index
	 * 
	 * @param index the index of the snake body
	 * @return the Position object stored in snakeBody[index]; null if index < 0 or 
	 * index >= snakeLength
	 */
	public Position getPosition(int index) {
		if (index < 0 | index >= snakeLength) {
			return null;
		}
		else return snakeBody[index];
	}
	
	/**
	 * decreases the value of snakeLength by 1
	 */
	public void shrink() {
		snakeLength = snakeLength - 1;
	}
	
	/**
	 * returns true if the position given is occupied by the snake
	 * 
	 * @param pos a given position 
	 * @return true if pos is in array snakeBody; false otherwise
	 */
	public boolean snakePosition(Position pos){
		boolean returnPosition = false;
		for (Position element : snakeBody) {
			if (element != null && pos.equals(element)) {
				returnPosition = true;
				break;
			}
		}
		return returnPosition;
	}
	
	/**
	 * returns the new position of the head of the snake when it moves
	 * 
	 * @param direction the direction where is snake is going. 
	 * The values that direction can take are “right”, “left”, “up” and “down”
	 * 
	 * @return the new position of the head of the snake when the snake moves 
	 * in the direction specified by the parameter
	 */
	public Position newHeadPosition(String direction) {
		Position changedPos = new Position(0,0);
		if (direction.contentEquals("right")){
			changedPos.setRow(snakeBody[0].getRow());
			changedPos.setCol(snakeBody[0].getCol()+1);
		}
		else if (direction.contentEquals("left")) {
			changedPos.setRow(snakeBody[0].getRow());
			changedPos.setCol(snakeBody[0].getCol()-1);
		}
		else if (direction.contentEquals("down")) {
			changedPos.setCol(snakeBody[0].getCol());
			changedPos.setRow(snakeBody[0].getRow()+1);
		}
		else if (direction.contentEquals("up")) {
			changedPos.setCol(snakeBody[0].getCol());
			changedPos.setRow(snakeBody[0].getRow()-1);
		}
		
		return changedPos;
	}
	
	/**
	 * moves the snake in the specified direction
	 * 
	 * @param direction the direction that the snake is going
	 */
	public void moveSnake(String direction) {
		for (int i = snakeLength-1; i>=1; i--) {
			snakeBody[i] = snakeBody[i-1];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	/**
	 * increases the length of the snake by 1 and moves the snake’s head 
	 * in the direction specified, increase the size of the array if it 
	 * is not large enough to store new information
	 * 
	 * @param direction the direction that the snake is going
	 */
	public void grow(String direction) {
		if (snakeLength == snakeBody.length) {
			increaseArraySize();
		}
		snakeLength = snakeLength + 1;
		for (int i = snakeBody.length-1; i>=1; i--) {
			snakeBody[i] = snakeBody[i-1];
		}
		snakeBody[0] = newHeadPosition(direction);
	}
	
	/**
	 * doubles the size of array snakeBody preserving the information that 
	 * was stored in it
	 */
	private void increaseArraySize() {
		Position newSnakeBody[] = new Position[snakeBody.length*2];
		for (int i = 0; i < snakeLength; i++) {
			newSnakeBody[i]=snakeBody[i];
		}
		snakeBody = newSnakeBody;
	}

}


