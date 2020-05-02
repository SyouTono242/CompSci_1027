public class ExceptionExample2 {

	private static boolean check(String name) throws Exception {
		if (name == null)
			throw new Exception("Error: null student name");
		return true;
	}

	public static void main(String[] args) {

		/*
		 * - unchecked exceptions: standard runtime exceptions methods need not state if
		 * they throw these
		 */

		final int NUM_STUDENTS = 5;

		String students[] = new String[NUM_STUDENTS];

		try {
			if (students[0].equals(""))
			students[0] = "John Doe";

			if (check(students[0]))
				System.out.println("First student's data is correct");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();}
			
	}
}