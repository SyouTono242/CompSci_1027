public class test {
	public static String s = "hey";
	public void changeString(String s) {
		s = "hi";
	}
	
	public test() {
	}

		public static void main (String[] args) {
			test test1 = new test();
			String a = "hello";
			test1.changeString(a);
			System.out.println(a);
		}
}