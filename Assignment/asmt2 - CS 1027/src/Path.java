
/**
 * This class finds the path from the start cell to the destination cell on 
 * the given map.
 * 
 * @author Yiran Shao
 *
 */
public class Path {
	
	Map cityMap;	// cityMap references the object representing the city map

	/**
	 * Constructor of the class.
	 * Receives an input as reference to a Map object representing the city map
	 * 
	 * @param theMap the Map object used as the city map 
	 */
	public Path (Map theMap) {
		cityMap = theMap;		// Initialize cityMap with the parameter theMap
	}
	
	
	/**
	 * This method looks for a path from the starting cell to the destination 
	 * cell.
	 * If a path is found, this method would print a message indicating how many 
	 * cells there were in the path. If no path was found, this method would print 
	 * an appropriate message.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void findPath() {
		ArrayStack stack = new ArrayStack(8,2,2);		// Create an empty stack.
		MapCell startCell = cityMap.getStart();			// Get the starting cell using 
														// getStart().
		stack.push(startCell);							// Push the starting cell into 
														// the stack.
		startCell.markInStack();						// Mark the cell as inStack using 
														// markInStack().
		MapCell currentCell = startCell;				// Initialize the currentCell.
		
		try {
			while (!stack.isEmpty()&&!currentCell.isDestination()) {	// While the stack is 
																	// not empty, and the 
																	// destination has not 
																	// been found:
				currentCell = (MapCell) stack.peek();			// Peek at the top of the 
																// stack to get the current 
																// cell.
				if (currentCell.isDestination()) {				// If the current cell is the 
																// destination:
					System.out.println("It took " + stack.size() + " cells in the path from the starting cell to the destination.");
					break;										// The algorithm exits the 
																// if loop.
				}
				else {
					MapCell bestCell = this.nextCell(currentCell);	// Find the best unmarked 
																	// neighbouring cell.
					if (bestCell != null) {							// If this cell exists:
						stack.push(bestCell);						// Push it into the stack
						bestCell.markInStack();						// Mark it as inStack
					}
					else {										// If there is no unmarked 
																// neighbouring cell that 
																// can be added to the path:
						stack.pop();							// Pop the top cell from the 
																// stack.
						currentCell.markOutStack();				// Mark it as outOfStack.
					}
				}
			}
			if (stack.isEmpty()&&!currentCell.isDestination()) { // When the stack is empty 
																 // but the destination is 
																 // not found.
				System.out.println("A path to the destination could not be found.");
			}
		} catch (EmptyStackException e) {					// Handle EmptyStackException.
			System.err.println("EmptyStackException: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the best map cell to continue the path from the current one.
	 * If there are no unmarked cells adjacent to the current one that can be used 
	 * to continue the path, this method returns null.
	 * 
	 * @param cell the current map cell
	 * @return 
	 * <ul>
	 * <li> If unmarked cells adjacent to the current one exists: The best map cell to continue the path from the current one
	 * 		<ul><li> If multiple unmarked cells are available: Return in order
	 * 			<ul><li> Destination cell
	 * 			<li> Road intersection cell with smallest index
	 * 			<li> North, east, south, or west road cell with smallest index
	 *</ul></ul><li> If no unmarked cell is available: null
	 *</ul>
	 */
	private MapCell nextCell(MapCell cell) {
		
		MapCell northNeighbour = cell.getNeighbour(0);		// Northern neighbour of currentCell
		MapCell eastNeighbour = cell.getNeighbour(1);		// Eastern neighbour of currentCell 
		MapCell southNeighbour = cell.getNeighbour(2);		// Southern neighbour of current
		MapCell westNeighbour = cell.getNeighbour(3);		// Western neighbour of currentCell
		
		MapCell returnCell = null;							// Initialize the Cell that is returned
		
		if (cell.isNorthRoad()) {							// If currentCell is NorthRoad:
			if (northNeighbour!=null && !northNeighbour.isMarked()) {
															// If currentCell's northern neighbour
															// exists and has not been not marked:
				if (northNeighbour.isDestination()||northNeighbour.isIntersection()||northNeighbour.isNorthRoad()) {
															// If it is Destination, Intersection 
															// or NorthRoad:
					returnCell = northNeighbour;			// Return the currentCell's northern 
															// neighbour.
				}
			}
		}
		else if (cell.isEastRoad()) {						// If currentCell is EastRoad:
			if (eastNeighbour!=null && !eastNeighbour.isMarked()) {
				if (eastNeighbour.isDestination()||eastNeighbour.isIntersection()||eastNeighbour.isEastRoad()) {
					returnCell = eastNeighbour;
				}
			}
		}
		else if (cell.isSouthRoad()) {						// If currentCell is SouthRoad
			if (southNeighbour!=null && !southNeighbour.isMarked()) {
				if (southNeighbour.isDestination()||southNeighbour.isIntersection()||southNeighbour.isSouthRoad()) {
					returnCell = southNeighbour;
				}
			}
		}
		else if (cell.isWestRoad()) {						// If currentCell is WestRoad
			if (westNeighbour!=null && !westNeighbour.isMarked()) {
				if (westNeighbour.isDestination()||westNeighbour.isIntersection()||westNeighbour.isWestRoad()) {
					returnCell = westNeighbour;
				}
			}
		}
		
		else if (cell.isIntersection() || cell.isStart()) {	// If currentCell is Intersection 
															// or startCell:
			for (int i = 0; i <= 3; i++) {					// Go through all of its neighbours
				MapCell neighbourCell = cell.getNeighbour(i);
				if (neighbourCell != null && !neighbourCell.isMarked()) {
															// If the neighbourCell exists and 
															// has not been marked:
					if (neighbourCell.isDestination()) {	// If neighbourCell is Destination:
						returnCell = neighbourCell;			// Return the Destination neighbourCell.
					}
					else if (neighbourCell.isIntersection() && (returnCell == null || (!returnCell.isDestination()&&!returnCell.isIntersection()))) {
															// Else if the neighbourCell is 
															// Intersection, no Destination 
															// or Intersection cells has been 
															// found among the neighbourCells:
						returnCell = neighbourCell;			// Return the Intersection neighbourCell.
					}
					else if ((i==0&&neighbourCell.isNorthRoad())||(i==1&&neighbourCell.isEastRoad())||(i==2&&neighbourCell.isSouthRoad())||(i==3&&neighbourCell.isWestRoad())) {
															// Else if a north, east, south, or 
															// west road neighbourCell exist at 
															// appropriate location
						if (returnCell == null) {			// If no Destination or Intersection
															// cells has been found yet:
							returnCell = neighbourCell;		// Return the one lane road cell.
						}
					}
					}
				}
		}
		return returnCell;
	}
}