/**
 * Build a linked list of integers from 1 to 10
 * 
 * @author CS1027
 */
public class RemoveLinkedList {

    private static LinearNode<Integer> front;

	public static void main(String[] args) {

		// Create a linked list that holds 1, 2, ...,5
		// by starting at 5 and adding each node at the front of list

		front = null; // create empty linked list
		LinearNode<Integer> intNode;

		for (int i = 5; i >= 1; i--) {
			// Create a new node for i
			intNode = new LinearNode<Integer>(new Integer(i));
			// Add it at the front of the linked list
			intNode.setNext(front);
			front = intNode;
		}

		printElements();
		// Remove the node storing the value 5 from the list
		remove(3);
		printElements();
		remove(1);
		printElements();
		remove(2);
		remove(4);
		remove(5);
		printElements();
	}

	// This method removes from the linked list referenced by front the node
	// storing the value specified by the second parameter
	private static void remove(int value) {
		LinearNode<Integer> current = front, previous = null;

		// Find the node storing value
		while (current != null) {
			if (current.getElement().intValue() == value && value != front.getElement().intValue()) { // node storing given value was found
				previous.setNext(current.getNext());
				break; // Exit loop
			}
			else if (current.getElement().intValue() == value && value == front.getElement().intValue()) {
				front = current.getNext();
				break;
			}
			else {
				previous = current;
				current = current.getNext();
			}
		}

	}

	// Prints the values stored in the list referenced by front
	private static void printElements() {
		System.out.print("List of elements: ");
		LinearNode<Integer> current = front;
		while (front != null) {
			System.out.print(current.getElement());
			current = current.getNext();
			if (current == null) break;			
			if (current != null)
				System.out.print(", ");
		}
		if (front == null) {
			System.out.print("No element is found in the list.");
		}
		System.out.println("");
	}
}
