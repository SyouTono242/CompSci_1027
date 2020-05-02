/**
 * Build a linked list of integers from 1 to 10
 * 
 * @author CS1027
 */
public class AddDoublyLinkedList {

	private static DoublyLinkedList<Integer> front;
	private static DoublyLinkedList<Integer> rear;

	public static void main(String[] args) {

		// Create a linked list that holds 1, 2, ...,5
		// by starting at 5 and adding each node at the front of list

		front = null; // create empty linked list
		rear = null; // create empty linked list
		DoublyLinkedList<Integer> intNode;

		for (int i = 5; i >= 1; i--) {
			// Create a new node for i
			intNode = new DoublyLinkedList<Integer>(new Integer(i));
			addAtRear(intNode);
		}
		printElements();
	}


	/* This method adds newNode to the end of the doubly linked list referenced by front */
	private static void addAtRear(DoublyLinkedList<Integer> newNode) {
		if (front != null && rear != null) {
			rear.setNext(newNode);
			newNode.setPrevious(rear);
			rear = newNode;
			}
		else {
			front = newNode;
			rear = newNode;
		}
		
		
	}


	// Prints the values stored in the list referenced by front
	private static void printElements() {
		System.out.print("List of elements (forward): ");
		DoublyLinkedList<Integer> current = front;
		while (true) {
			System.out.print(current.getElement());
			current = current.getNext();
			if (current == null)
				break;
			if (current != null)
				System.out.print(", ");
		}
		System.out.println("");
		
		System.out.print("\nList of elements (backward): ");
		current = rear;
		while (true) {
			System.out.print(current.getElement());
			current = current.getPrevious();
			if (current == null)
				break;
			if (current != null)
				System.out.print(", ");
		}
		System.out.println("");
	}
}
