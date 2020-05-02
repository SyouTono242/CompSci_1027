
/**
 * This class implements a stack using an array
 * 
 * @author Yiran Shao
 *
 */

public class ArrayStack<T> implements ArrayStackADT<T>{
	
	
	private T[] stack;				// This array stores the data items of the stack
	private int top;				// This variable stores the position of the last data item in the stack
	private int initialCapacity;	// This is the initial size of the array stack
	private int sizeIncrease;		// The size of the array increases by this amount
	private int sizeDecrease;		// The size of the array will decrease by this amount
	
	
	/**
	 * Constructor of the class.
	 * Creates an empty stack using an array of length equal to the value of 
	 * the first parameter
	 * 
	 * @param initialCap initial size of the array stack, stored in initialCapacity
	 * @param sizeInc amount of increase of the size of the array stack, 
	 * stored in sizeIncrease
	 * @param sizeDec amount of decrease of the size of the array, stored 
	 * in sizeDecrease
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
		top = -1;								// Initialize the stack to be empty.
		stack = (T[]) new Object[initialCap];	// Initialize the stack using an array of length initialCap
		initialCapacity = initialCap;
		sizeIncrease = sizeInc;
		sizeDecrease = sizeDec;
	}

	/**
	 * Adds dataItem to the top of the stack and updates the value of top.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void push(T dataItem) {
		if (top >= (stack.length -1)) {			// Check if the array is full.
			T[] newStack = (T[]) new Object [stack.length + sizeIncrease];	// Increase capacity.
			for(int i = 0; i <= top; i++) {		// Copy the the objects in the array to the new array.
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		stack[++top] = dataItem;				// Add dataItem to the top and increase the top by 1.
	}

	/**
	 * Removes and returns the data item at the top of the stack and updates 
	 * the value of top.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T pop() throws EmptyStackException {
		if (this.isEmpty()) {					// Check if the stack is empty.
			throw new EmptyStackException("Stack Underflow: No item found in the stack.");
		}
		else {
			T topDataitem = stack[top--];		// Remove the dataItem at the top
			if (this.size() < (stack.length/4) && stack.length > initialCapacity) {		
												// Check if the number of data items remaining 
												// is smaller than one fourth of the length of 
												// the array and the length of the array is 
												// larger than initalCapacity.
				T[] newStack = (T[]) new Object [stack.length - sizeDecrease];
												// Reduce the size of the array by sizeDecrease
				for(int i = 0; i <= top; i++) {
					newStack[i] = stack[i];
				}
				stack = newStack;
			}
			return topDataitem;
		}
	}

	/**
	 *  Returns the data item at the top of the stack without removing it.
	 */
	@Override
	public T peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException("Stack Underflow: No item found in th stack.");
		}
		else {
			T topDataitem = stack[top];
			return topDataitem;
		}
	}

	/**
	 * Returns true if the stack is empty and returns false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return (top<0);
	}

	/**
	 * Returns the number of data items in the stack.
	 * @return number of data items in the stack
	 */
	@Override
	public int size() {
		return top+1;
	}
	/**
	 * Returns the length or capacity of the array stack
	 * @return length of the array stack
	 */
	public int length() {
		return stack.length;
	}
	
	/**
	 * Returns a String representation of the stack.
	 */
	public String toString() {
		StringBuffer out = new StringBuffer();
		if (!this.isEmpty()) {
			for(int i = 0; i < top; i++)
				out.append(stack[i] + ", ");
			out.append(stack[top]);
			return "Stack: " + out.toString();
		}
		else return "No data item found in the stack.";
	}
	
}
