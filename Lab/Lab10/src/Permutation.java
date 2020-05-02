import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {
	
	private static String removeChar(String s, int i) {
	     return s.substring(0,i) + s.substring(i+1,s.length());
	}
	
	public static void permutations(String prefix, String suffix) {
		char c;
		String suff;
		String pre;
		
		if (suffix.length()==0) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < suffix.length(); i++) {
				c = suffix.charAt(i);
				suff = removeChar(suffix,i);
				pre = c+prefix;
				permutations(pre,suff);
			}
		}
	}
	
	public static void main(String arg[]) throws IOException {
		String inputString;
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        inputString = keyboard.readLine();
        
        permutations("",inputString);
	}

}
