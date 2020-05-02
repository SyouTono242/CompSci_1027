
/**
 * This class implements an ordered list using a circular array.
 * 
 * @author Yiran Shao
 *
 */
public class OrderedCircularArray<T> implements SortedListADT<T> {
	
	private CellData[] list;	// This array stores the data items of the ordered list
	private int front;			// This variable stores the position of the first data item in the list (smallest, initialized to 1)
	private int rear;			// This is the index of the last data item in the ordered list (largest, initialized to 0)
	private int count;			// The value of this variable is equal to the number of data items in the list
	
	/**
	 * Constructor of the class. Initializes the instance variables to be
	 * 		front == 1;
	 * 		rear == 0;
	 * 		list.length == 5;
	 */
	@SuppressWarnings("unchecked")
	public OrderedCircularArray() {
		front = 1;
		rear = 0;
		list = (CellData<T>[]) new CellData[5];
	}
	
	/**
	 * Adds a new CellData object storing the given id and value to the ordered list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert (T id, int value) {
		if (count == list.length) {									// If the array is full:
			CellData[] tempList = (CellData<T>[]) new CellData[2*list.length];
			int currPos1 = front;		// Current position in the old list (list)
			int currPos2 = front;		// Current position in the new list (tempList)
			while(currPos1 != rear) {	// Copy every cell (except for the rear) from the old list to the new list
				T currId = (T) list[currPos1].getId();
				int currVal = list[currPos1].getValue();
				CellData newCell = new CellData(currId,currVal);
				tempList[currPos2] = newCell;
				currPos1 = (currPos1+1)%list.length;
				currPos2 = (currPos2+1)%tempList.length;
			}
			T rearId = (T) list[rear].getId();
			int rearVal = list[rear].getValue();
			CellData rearCell = new CellData(rearId,rearVal);
			tempList[currPos2] = rearCell;
			rear = currPos2;			// Change the rear
			list = tempList;
		}
		
		int newPos;						// Position where the new cell is going to be inserted
		CellData newCell = new CellData(id,value);
		if (isEmpty()) {				// If the list is empty (i.e. the new cell is the only cell in the list)
			list[front] = newCell;
			rear = front;				// Make both rear and front point at the new cell
		}
		else {
			if (value < list[front].getValue()) {			// If the new cell is the smallest:
				newPos = front;
				shift(newPos);
				list[newPos] = newCell;
			}
			else if (value >= list[rear].getValue()) {		// If the new cell is the largest:
				newPos = (rear+1)%list.length;
				list[newPos] = newCell;
				rear = (rear+1)%list.length;
			}
			else {											// If the new cell should be placed in the middle
				int currPos = front;
				int nextPos = (front+1)%list.length;
				Boolean found = false;
				while ((nextPos != rear)&&(found==false)) {
					int currVal = list[currPos].getValue();
					int nextVal = list[nextPos].getValue();
					if ((currVal<=value)&&(nextVal>value)) {
						found = true;
						break;
					}
					currPos = nextPos;
					nextPos = (nextPos+1)%list.length;
				}
				newPos = nextPos;
				shift(newPos);
				list[newPos] = newCell;
			}
		}
		count++;											// Increase the count after adding the cell
	}
	
	/**
	 * Returns the integer value of the CellData object with the specified id
	 * An InvalidDataItemException is thrown if no CellData object with the given id is in the ordered list
	 */
	public int getValue(T id) throws InvalidDataItemException{
		int badPos = findPosById(id);
		int returnValue = list[badPos].getValue();
		return returnValue;
	}
	
	/**
	 * Removes from the ordered list the CellData object with the specified id
	 * An InvalidDataItemException is thrown if no CellData object in the ordered list has the specified id
	 */
	public void remove(T id) throws InvalidDataItemException{
		int badPos = findPosById(id);					// Find the position of the cell to be removed
		if (badPos==front) {							// If the cell is at the front:
			getSmallest();								// Use getSmallest instead
		}
		else {											// If the cell is not at the front:
			int prevPos = badPos;
			int currPos = (badPos+1)%list.length;
			while(currPos != (rear+1)%list.length) {
				list[prevPos] = list[currPos];
				prevPos = (prevPos+1)%list.length;
				currPos = (currPos+1)%list.length;
			}
			if (rear == 0) {							// Shift the rear backward
				rear = list.length-1;
			}
			else {
				rear = (rear-1)%list.length;
			}
			count--;									// Decrease count after deleting the cell
		}
	}
	
	/**
	 * Changes the value attribute of the CellData object with the given id to the specified newValue
	 */
	public void changeValue (T id, int newValue) throws InvalidDataItemException{
		remove(id);
		insert(id,newValue);
	}
	
	/**
	 * Removes and returns the id of the CellData object in the ordered list with smallest associated value
	 */
	@SuppressWarnings("unchecked")
	public T getSmallest() throws EmptyListException{
		if (count == 0) {								// If no object is in the list
			throw new EmptyListException("No object found in the list.");
		}
		else {
			T smallestId = (T) list[front].getId();
			front = (front+1)%list.length;				// Make the front point to the second element in the list
			count--;									// Decrease the count after deleting the smallest cell
			return smallestId;
		}
	}
	
	/**
	 * Returns true if the ordered list is empty and it returns false otherwise
	 */
	public boolean isEmpty() {
		return (count <= 0);
	}
	
	/**
	 * Returns the number of data items in the ordered list
	 */
	public int size(){
		return count;
	}
	
	/**
	 * Returns the value of instance variable front
	 */
	public int getFront() {
		return front;
	}
	
	/**
	 * Returns the value of instance variable rear
	 */
	public int getRear() {
		return rear;
	}
	
	
	/**
	 * Searches through the array for the cell with given id and returns its index
	 * @param id	The id of the cell to be searched for
	 * @return		The index of the cell with the given id
	 * @throws InvalidDataItemException	When no cell with the given id is found
	 */
	private int findPosById(T id) throws InvalidDataItemException{
		
		int currPos = front;						// Starting at the front
		
		for (int i=0; i<count; i++) {				// Compare the id of every object in the list with the given id
			if (list[currPos].getId().equals(id)) {
				return currPos;
			}
			else {
				currPos = (currPos+1)%list.length;
			}
		}
		throw new InvalidDataItemException("No object with the given id is found.");
	}
	
	
	/**
	 * Shifts every cell from newPos to the last object towards the rear by 1 and increase rear by 1
	 * @param newPos
	 */
	@SuppressWarnings("unchecked")
	private void shift(int newPos) {
		int currPos = rear;						// Starting at the rear
		int nextPos = (rear+1)%list.length;
		CellData rearCell = new CellData(list[rear].getId(),list[rear].getValue());
		list[nextPos] = rearCell;
		while (currPos != (newPos-1)%list.length) {
			list[nextPos] = list[currPos];
			nextPos = currPos;
			currPos = (currPos-1)%list.length;
		}
		rear = (rear+1)%list.length;			// Increase rear by 1
	}

}
