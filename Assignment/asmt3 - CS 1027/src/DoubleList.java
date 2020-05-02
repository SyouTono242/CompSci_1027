
/**
 * This class represents a doubly linked list of nodes of the class DoubleNode
 * 
 * @author Yiran Shao
 *
 */
public class DoubleList<T> {
	private DoubleNode<T> head;		// This is a reference to the first node in the list
	private DoubleNode<T> rear;		// This is a reference to the last node in the list
	private int numDataItems;		// This is the number of nodes in the list
	
	/**
	 * This creates an empty list with zero nodes
	 */
	public DoubleList() {
		numDataItems = 0;
		head = null;
		rear = null;
	}
	
	/**
	 * This method adds a new node to the list storing newData in the index position.
	 *  
	 * @param index Position at which the node is inserted
	 * @param newData Data stored in the newNode
	 * @throws InvalidPositionException
	 */
	public void addData (int index, T newData) throws InvalidPositionException{
		if (index < 0 || index > numDataItems) {						// Throw an exception when the input index is out of range
			throw new InvalidPositionException("Index out of range!");
		}
		else {
			DoubleNode<T> newNode = new DoubleNode<T>(newData);			// Create a newNode storing the newData
			if (numDataItems == 0) {									// Place the newNode in the empty list
				head = newNode;
				rear = newNode;
			}
			else {
				if (index == 0) {										// Place the newNode as the head when the index == 0
					newNode.setNext(head);
					head.setPrev(newNode);
					head = newNode;
				}
				else if (index == numDataItems) {						// Place the newNode as the tail when the index == numDataItems
					newNode.setPrev(rear);
					rear.setNext(newNode);
					rear = newNode;
				}
				else {													// Place the newNode in the middle when the index is neither 0 nor numDataItems
					DoubleNode<T> prevNode = head;
					DoubleNode<T> nextNode = head.getNext();
					for (int i = 1; i < index-1; i++) {
						prevNode = prevNode.getNext();
						nextNode = nextNode.getNext();
					}
					newNode.setPrev(prevNode);
					newNode.setNext(nextNode);
					prevNode.setNext(newNode);
					nextNode.setPrev(newNode);
				}
			}
			numDataItems++;												// Increase the number of nodes in the list by 1
		}
	}
	
	/**
	 * Returns the node that is at the index position of the list.
	 * 
	 * @param index position at which the node is returned
	 * @return node at the index position of the list
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException{
		if (index < 0 || index >= numDataItems) {						// Throw an exception when the input index is out of range
			throw new InvalidPositionException("Index out of range.");
		}
		else {
			DoubleNode<T> returnNode = head;							// Search for the node at the position index
			for (int i = 0; i < index; i++) {
				returnNode = returnNode.getNext();
			}
			return returnNode;											// Return the node
		}
	}
	
	/**
	 * Removes the node that is at the index position of the list
	 *  
	 * @param index position at which the node is removed
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException{
		if (index < 0 || index >= numDataItems) {						// Throw an exception when the input index is out of range
			throw new InvalidPositionException("Index out of range.");
		}
		else {
			if (numDataItems == 1) {
				head = null;
				rear = null;
			}
			else {
				DoubleNode<T> badNode = head.getNext();
				DoubleNode<T> prevNode = head;
				DoubleNode<T> nextNode = badNode.getNext();
				if (index == 0) {											// Remove the first node when index == 0
					badNode = head;
					nextNode = badNode.getNext();
					nextNode.setPrev(null);
					head = nextNode;
				}
				else if (index == numDataItems - 1) {						// Remove the last node when index == numDataItems-1
					badNode = rear;
					prevNode = badNode.getPrev();
					prevNode.setNext(null);
					rear = prevNode;
				}
				else {														// Remove the nodes in the middle of the list
					for (int i = 1; i < index-1; i++) {
						nextNode = nextNode.getNext();
						badNode = badNode.getNext();
						prevNode = prevNode.getNext();
					}
					prevNode.setNext(nextNode);
					nextNode.setPrev(prevNode);
				}
			}
			numDataItems--;												// Decrease the size of the list by 1
		}
	}
	
	/**
	 * Returns the data stored in the node located at the index position of the list
	 * 
	 * @param index position at which the data is obtained
	 * @return
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException{
		if (index < 0 || index >= numDataItems) {						// Throw an exception when the input index is out of range
			throw new InvalidPositionException("Index out of range.");
		}
		else {
			DoubleNode<T> returnNode = getNode(index);					// Get the node at the position index
			T returnData = returnNode.getData();						// Get the data stored in that node
			return returnData;											// Return that data
		}
	}
	
	/**
	 * Store newData at the node in position index of the list
	 * 
	 * @param index at which the data is renewed
	 * @param newData
	 * @throws InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException{
		if (index < 0 || index >= numDataItems) {						// Throw an exception when the input index is out of range
			throw new InvalidPositionException("Index out of range");
		}
		else {
			DoubleNode<T> changedNode = getNode(index);					// Get the node at the position index
			changedNode.setData(newData);								// Change the data stored in that node to newData
		}
	}
}
