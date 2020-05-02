
/*
**  A java class that tests the implementation of CircularArrayQueue
**
**  @author CS1027
** 
*/
import java.util.Scanner;

public class TestCAQ {

	// Test method "first"
	public static void testFirst(CircularArrayQueue<Object> q, Object expected, CircularArrayQueue<Object> q2) {
		Object result = q.first();
		if (!result.equals(expected))
			System.out.println("   Test Failed\n");
		else {
			try {
				result = q2.first();
				System.out.println("Testing method \"front\": Test Failed\n");
			} catch (EmptyCollectionException e) {
				System.out.println("Testing method \"front\": Test passed\n");
			} catch (Exception e) {
				System.out.println("Testing method \"front\": Test Failed\n");
			}
		}
	}

	public static void main(String args[]) throws Exception {
		CircularArrayQueue<Object> queue, queue2;
		Object result;
		Scanner input = new Scanner(System.in);
		String option = "";
		do {
			System.out.print("Enter test number: ");
			option = input.nextLine();
			if (option.equals("1")) {
				// Add data items "1", "2", "3" to queue and verify that the data item
				// at the front is "1", also check that queue2 is empty
				queue = new CircularArrayQueue<Object>(5);
				queue2 = new CircularArrayQueue<Object>();
				for (int i = 1; i < 4; ++i)
					queue.enqueue(new Integer(i));
				testFirst(queue, new Integer(1), queue2);
			} else if (option.equals("2") || option.equals("3")) {
				// Add data items "0", "1","2", "3" to queue
				queue = new CircularArrayQueue<Object>(5);
				for (int i = 0; i < 4; ++i)
					queue.enqueue("" + i);
				queue.enqueue("4");
				if (option.equals("2"))
					System.out.println("Testing method \"enqueue\": Test passed\n");
				else {
					// Test number 3. Add one more item to the queue so the program
					// must expand the capacity of the array
					queue.enqueue("5");
					result = queue.first();
					if (result.equals("0"))
						System.out.println("Testing method \"enqueue\": Test passed\n");
					else {
						System.out.println("Testing method \"enqueue\": Test failed");
						System.out.println("Method \"first\" returned value \"" + result + "\"\n");
					}
				}
			} else if (option.equals("4")) {
				queue = new CircularArrayQueue<Object>(4);
				for (int i = 1; i <= 4; ++i)
					queue.enqueue("" + i);
				for (int i = 1; i <= 4; ++i)
					result = queue.dequeue();
				System.out.println("Testing method \"dequeue\": Test passed\n");
			} else if (option.equals("5")) {
				queue = new CircularArrayQueue<Object>(4);
				queue.enqueue("1");
				queue.enqueue("2");
				queue.enqueue(new Integer(10));
				queue.enqueue(new Integer(20));
				queue.enqueue(new EmptyCollectionException("Exception Object 5"));
				String res = queue.toString();
				if (res.equals("QUEUE: 1, 2, 10, 20, EmptyCollectionException: The Exception Object 5 is empty."))
					System.out.println("Testing method \"toString\": Test passed\n");
				else
					System.out.println("Testing method \"toString\": Test failed\n");
			}
		} while (!option.equals("0"));
		System.out.println("Program ended");
	}
}
