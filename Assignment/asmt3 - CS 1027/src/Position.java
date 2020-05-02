
/**
 * The class Position stores the row position and the column position in two private 
 * integer variables, positionRow and positionColumn
 * 
 * @author Yiran Shao
 *
 */
public class Position {
	private int positionRow;  		// The row position of a square of the grid
	private int positionColumn;  	// The column position of a square of the grid
	
	/**
	 * The constructor of the class.
	 * stores the row and column information
	 * in the two private integer variables, positionRow and positionColumn,
	 * repectively
	 * 
	 * @param row the row position 
	 * @param col the column position
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionColumn = col;
	}
	
	/**
	 * getRow method returns the row position
	 * 
	 * @return row position
	 */
	public int getRow() {
		return positionRow;
	}
	
	/**
	 * getCol method returns the column position
	 * 
	 * @return column position
	 */
	public int getCol() {
		return positionColumn;
	}
	
	/**
	 * setRow method stores the value of the newRow in positionRow
	 * 
	 * @param newRow new row position
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	
	/**
	 * setCol method stores the value of the newCol in positionColumn
	 * 
	 * @param newCol new column position
	 */
	public void setCol(int newCol) {
		positionColumn = newCol;
	}
	
	/**
	 * equals method returns true if this Position object and otherPosition 
	 * have the same values stored in positionRow and positionColumn
	 * 
	 * @param otherPosition another Position object
	 * @return true if the two Position objects have the same values in 
	 * positionRow and positionColumn by using the getRow() and getCol() methods
	 * false if they are not at the same position
	 */
	public boolean equals(Position otherPosition) {
			if (this.getRow() == otherPosition.getRow() & this.getCol() == otherPosition.getCol()) {
				return true;
			}
			else return false;
		}
	}