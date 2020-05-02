public class DoublyLinkedStack<T> implements StackADT<T> {
	/** indicates number of elements stored */
	private int count;
	/** pointer to top of stack */
	private DoublyLinkedList<T> top;

	/**
	 * Creates an empty stack.
	 */
	public DoublyLinkedStack() {
		count = 0;
		top = null;
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * 
	 * @param element element to be pushed on stack
	 */
	public void push(T element) {
		DoublyLinkedList<T> temp = new DoublyLinkedList<T>(element);

		if (top == null) {
			top = temp;
		}
		temp.setNext(top);
		top.setPrevious(temp);
		top = temp;
		count++;
	}

	/**
	 * Removes the element at the top of this stack and returns a reference to it.
	 * Throws an EmptyCollectionException if the stack is empty.
	 * 
	 * @return T element from top of stack
	 * @throws EmptyCollectionException on pop from empty stack
	 */
	public T pop() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");

		T result = top.getElement();
		top = top.getNext();
		if (top != null)
			top.setPrevious(null);
		count--;

		return result;
	}

	/**
	 * Returns a reference to the element at the top of this stack. The element is
	 * not removed from the stack. Throws an EmptyCollectionException if the stack
	 * is empty.
	 * 
	 * @return T element on top of stack
	 * @throws EmptyCollectionException on peek at empty stack
	 */
	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Stack");

		return top.getElement();
	}

	/**
	 * Returns true if this stack is empty and false otherwise.
	 * 
	 * @return boolean true if stack is empty
	 */
	public boolean isEmpty() {
		return (count == 0);
	}

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return int number of elements in this stack
	 */
	public int size() {
		return count;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return String representation of this stack with the elements in reverse
	 *         order: first the element in the bottom and last the element at the
	 *         top. Note that DoublyLinkedList does not have a toString() method.
	 *         The stack is not changed.
	 */
	public String toString() {
		DoublyLinkedList<T> current = top;
		String returnString = "Stack: ";
		for (int i = 0; i < count-1; i++) {
			current = current.getNext();
		}
		while (top != null) {
			returnString = returnString + current.getElement();
			current = current.getPrevious();
			if (current == null) break;			
			if (current != null)
				returnString = returnString + ", ";
		}
		if (top == null) {
			returnString = returnString + "No element in the stack.";
		}
		return returnString;

	}

}
