
/**
 * This is the class of exceptions that will be thrown by methods pop and peek 
 * when invoked on an empty stack.
 * 
 * @author Yiran Shao
 *
 */

public class EmptyStackException extends Exception {
	
	/**
	 * Constructor of this class
	 * When an object of this class is created an appropriate 
	 * message is passed as parameter explaining why the exception 
	 * was thrown.
	 * 
	 * @param message the message explaining the cause of the 
	 * exception thrown
	 */
	public EmptyStackException(String message) {
		super(message);
	}
}