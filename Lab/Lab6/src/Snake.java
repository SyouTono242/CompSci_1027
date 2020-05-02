/* This class implements the snake object in the snake game */
public class Snake {
	private Position[] snakeBody; /* Array that stores the board positions occupied by the snake */
	private int length; /* Length of the snake */

	public Snake(int row, int col) {
		snakeBody = new Position[5];
		snakeBody[0] = new Position(5, 8); // Initially the snake is at row 5, column 8
		length = 1; // and it has length 1
	}

	/*
	 * This version of the snake game does not increase the length of the snake, so
	 * this method just moves the snake one position over
	 */
	public void grow(String direction) {
		Position newHead = newHeadPosition(direction);
		snakeBody[0] = newHead;
	}

	/*
	 * This version of the game does not change the length of the snake, so the
	 * shrink method does not do anything.
	 */
	public void shrink() {
	}

	/*
	 * This method determines the new postion where the head of the snake should be
	 * if the snake were to move in the direction specified by the parameter. Notice
	 * that this method does not actually moves the snake, it just determines the
	 * new position for the head.
	 */
	public Position newHeadPosition(String direction) {
		Position head = new Position(snakeBody[0].getRow(), snakeBody[0].getCol());
		int row = head.getRow();
		int col = head.getCol();
		if (direction.equals("right"))
			head.setCol(col + 1);
		else if (direction.equals("left"))
			head.setCol(col - 1);
		else if (direction.equals("up"))
			head.setRow(row - 1);
		else
			head.setRow(row + 1);
		return head;

	}

	/* This method moves the snake in the direction specified by the parameter */
	public void moveSnake(String direction) {
		snakeBody[0] = newHeadPosition(direction);
	}

	/*
	 * This method returns true if the Position object passed as a parameter is
	 * contained in the snakeBody array; it returns false otherwise.
	 */
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < length; ++i)
			if (snakeBody[i].equals(pos))
				return true;
		return false;
	}

	/*
	 * This method returns the Position object stored in the entry specified by the
	 * parameter of the snakeBody array.
	 */
	public Position getPosition(int index) {
		if (index != 0)
			return null;
		else
			return snakeBody[0];
	}

	/*
	 * Returns the length of the snake. Since this version of the game does not
	 * change the length of the snake, this method always returns 1.
	 */
	public int getLength() {
		return 1;
	}

}