import java.io.*;

public class ExceptionExample11 {

   public static void main (String[] args) throws Exception {

      /* 
         - this handles the NumberFormatException

      */
	   
	  Boolean success = false;

	  while (success != true) {
		  BufferedReader keyboard=
			         new BufferedReader (new InputStreamReader(System.in),1);

			      System.out.print("Enter an integer: ");
			      String userTyped = keyboard.readLine();

			      try {
			         int value = Integer.parseInt(userTyped);
			         success = true;
			         System.out.println("Success");
			      }
			      catch (NumberFormatException e) {
			         System.out.println("Hey, " + e.getMessage() + " is not an integer!");
			      }
		  
	  }
   }
}