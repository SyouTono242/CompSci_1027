/**
 * 
 * @author Yiran Shao
 *
 */
public class ShortestPath {
	
	CityMap cityMap;	// This variable references the object representing the city map 

	/**
	 * Constructor of the class.
	 * It receives as input a reference to a CityMap object representing the city map
	 * 
	 * @param theMap
	 */
	public ShortestPath (CityMap theMap) {
		cityMap = theMap;
	}
	
	/**
	 * Looks for a path with the minimum number of map cells from the starting cell to 
	 * the destination cell
	 * If a path is found, this method prints a message indicating how many cells there 
	 * were in the path (starting cell and destination cell included)
	 * If no path was found, this method prints the message “No path found”
	 * 
	 */
	public void findShortestPath() {
		Boolean pathFound = false;
		OrderedCircularArray<MapCell> list = new OrderedCircularArray<MapCell>();
		MapCell startCell = cityMap.getStart();
		list.insert(startCell, 0);
		startCell.markInList();
		while ((!list.isEmpty())&&(!pathFound)){
			MapCell smallCell = list.getSmallest();
			smallCell.markOutList();
			if (smallCell.isDestination()) {
				pathFound = true;
				break;
			}
			else {
				while(nextCell(smallCell)!=null) {
					MapCell neighbourCell = nextCell(smallCell);
					int oldDistance = 1 + smallCell.getDistanceToStart();
					if (neighbourCell.getDistanceToStart()>oldDistance) {
						neighbourCell.setDistanceToStart(oldDistance);
						neighbourCell.setPredecessor(smallCell);
					}
					int newDistance = neighbourCell.getDistanceToStart();
					if (neighbourCell.isMarkedInList()&&(newDistance<list.getValue(neighbourCell))) {
						list.changeValue(neighbourCell, newDistance);
					}
					else if(!neighbourCell.isMarkedInList()) {
						list.insert(neighbourCell, newDistance);
						neighbourCell.markInList();
					}
				}
			}
		}
		
	}
	
	/**
	 * This method returns the first unmarked neighboring map cell that can be used to 
	 * continue the path from the current one
	 * If there are no unmarked cells adjacent to the current one that can be used to 
	 * continue the path, this method returns null
	 * @param cell	the current map cell
	 * @return
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
					if (neighbourCell.isDestination()||neighbourCell.isIntersection()||(i==0&&neighbourCell.isNorthRoad())||(i==1&&neighbourCell.isEastRoad())||(i==2&&neighbourCell.isSouthRoad())||(i==3&&neighbourCell.isWestRoad())) {	// If neighbourCell is Destination:
						returnCell = neighbourCell;			// Return the Destination neighbourCell.
					}
					}
				}
		}
		return returnCell;
	}
}
		
