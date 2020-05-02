
/**
 * This class represents the data items that will be stored in the circular array
 * 
 * @author Yiran Shao
 *
 */
public class CellData<T> {
	
	private T id;		// A reference to the identifier stored in this object
	private int value;	// The value of the data item stored in this object
	
	/**
	 * Constructor for the class. Initializes id to theId and value to theValue.
	 * 
	 * @param theId		The id of the object
	 * @param theValue	The value stored in the object
	 */
	public CellData(T theId, int theValue) {
		id = theId;
		value = theValue;
	}
	
	/**
	 * Returns instance variable value
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns instance variable id
	 * @return
	 */
	public T getId() {
		return id;
	}
	
	/**
	 * Assigns newValue to instance variable value
	 * 
	 * @param newValue	New value to be assigned to the object
	 */
	public void setValue(int newValue) {
		value = newValue;
	}
	
	/**
	 * Assigns the value of newId to instance variable id
	 * 
	 * @param newId		New id to be assigned to the object
	 */
	public void setId(T newId) {
		id = newId;
	}

}
