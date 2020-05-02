public class Position {
	private int row, column;
	
	public Position(int r, int c) {
		row = r;
		column = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return column;
	}
	
	public void setRow(int newRow) {
		row = newRow;
	}
	
	public void setCol(int newCol) {
		column = newCol;
	}
	
	public boolean equals(Position otherPosition) {
		return ((row == otherPosition.getRow()) && (column == otherPosition.getCol()));
	}
}