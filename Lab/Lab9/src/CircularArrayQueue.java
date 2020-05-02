/**
 * CircularArrayQueue represents an array implementation of a queue in which the
 * indexes for the front and rear of the queue circle back to 0 when they reach
 * the end of the array.
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @author CS1027
 */

public class CircularArrayQueue<T> implements QueueADT<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int count; 	// Number of data items in the queue
	private int front; 	// Index of the first data item in the queue, 1
	private int rear; 	// Index of the last data item in the queue, 0
	private T[] queue;	// Array where the data items of the queue will be stored

	/**
	 * Creates an empty queue using an array of the default capacity.
	 */
	public CircularArrayQueue() {
		front = 1;
		rear = 0;
		count = 0;
		queue = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	/**
	 * Creates an empty queue using the specified capacity.
	 * 
	 * @param initialCapacity the integer representation of the initial size of the
	 *                        circular array queue
	 */
	public CircularArrayQueue(int initialCapacity) {
		front = 1;
		rear = 0;
		count = 0;
		queue = ((T[]) (new Object[initialCapacity]));
	}

	/**
	 * Adds the specified element to the rear of this queue, expanding the capacity
	 * of the queue array if necessary.
	 * 
	 * @param element the element to add to the rear of the queue
	 */
	public void enqueue(T element) {
		if (size() == queue.length)
			expandCapacity();
			
		rear = (rear+1) % queue.length;
		queue[rear] = element;
		count++;
	}

	/**
	 * Removes the element at the front of this queue and returns a reference to it.
	 * Throws an EmptyCollectionException if the queue is empty.
	 *
	 * @return the reference to the element at the front of the queue that was
	 *         removed
	 * @throws EmptyCollectionException if an empty collections exception occurs
	 */
	public T dequeue() throws EmptyCollectionException {
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		if (front > queue.length)
			front = 0;
		count--;

		return result;
	}

	/**
	 * Returns a reference to the element at the front of this queue. The element is
	 * not removed from the queue. Throws an EmptyCollectionException if the queue
	 * is empty.
	 *
	 * @return a reference to the first element in the queue
	 * @throws EmptyCollectionException if an empty collections exception occurs
	 */
	public T first() throws EmptyCollectionException {
		if (count == 0) {
			throw new EmptyCollectionException("Empty queue.");
		}
		else {
			T result = queue[front];
			return result;
		}
	}

	/**
	 * Returns true if this queue is empty and false otherwise.
	 * 
	 * @return returns true if this queue is empty and false if otherwise
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of elements currently in this queue.
	 * 
	 * @return the integer representation of the size of this queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	public String toString() {
		String result = "QUEUE: ";
		int curr = front;
		for (int i = 0; i < count-1; i++) {
			result += queue[curr].toString()+", ";
			curr = (curr+1) % queue.length;
		}
		result += queue[curr].toString();
		return result;
	}

	/**
	 * Creates a new array to store the contents of this queue with twice the
	 * capacity of the old one.
	 */
	public void expandCapacity() {
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) new Object[queue.length * 2];

		for (int i = 1; i < count; i++)
			larger[i] = queue[i];
		larger[count] = queue[0];
		rear = count;

		queue = larger;
	}
}
