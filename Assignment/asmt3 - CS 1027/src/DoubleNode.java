
/**
 * This class represents the nodes in a doubly linked list.
 * 
 * @author Yiran Shao
 * 
 */
public class DoubleNode<T> {
	private DoubleNode<T> next;		// A reference to the next node in the list
	private DoubleNode<T> prev;		// A reference to the previous node in the list
	private T data;					// The data stored in this node
	
	/**
	 * Creates an empty node, where all instance variables are null.
	 */
	public DoubleNode () {
		next = null;
		prev = null;
		data = null;
	}
	
	/**
	 * Creates a node storing the given data in which next and prev are null
	 * @param newData
	 */
	public DoubleNode (T newData) {
		next = null;
		prev = null;
		data = newData;
	}
	
	/**
	 * Returns the value of next
	 * @return
	 */
	public DoubleNode<T> getNext(){
		return next;
	}
	
	/**
	 * Returns the value of prev
	 * @return
	 */
	public DoubleNode<T> getPrev(){
		return prev;
	}
	
	/**
	 * Returns the value of data
	 * @return
	 */
	public T getData () {
		return data;
	}
	
	/**
	 * Stores nextNode in next
	 */
	public void setNext (DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * Stores prevNode in prev
	 * @param prevNode
	 */
	public void setPrev (DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Stores newData in data
	 * @param newData
	 */
	public void setData (T newData) {
		data = newData;
	}
}
