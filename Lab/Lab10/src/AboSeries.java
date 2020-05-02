
public class AboSeries {
	
	public static long rabo(long n) {
		if (n <= 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			if (n%2 == 0) {
				return (1 + rabo(n/2));
			}
			else{
				return (2 + rabo((n+1)/2));
			}
		}
	}
	
	
	public static void main(String args[]) {
		for (int n=0;n<20;n++) {
			System.out.println("Abo("+n+")="+rabo(n));
		}
	}

}
