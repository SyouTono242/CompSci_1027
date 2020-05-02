
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		int x;
		int y;
		char c = '+';

		Scanner input = new Scanner(System.in);
		while (c == '+' || c == '-') {
			System.out.println("Enter a number:");
			x = input.nextInt();
			System.out.println("Enter a second number:");
			y = input.nextInt();
			System.out.println("enter an arithmetic operator '+' or '-':");
			c = input.next().charAt(0);
			if (c == '+') System.out.println("Result = "+(x+y));
			  else if (c == '-') System.out.println("Result = "+(x-y));
		  }

	}

}
