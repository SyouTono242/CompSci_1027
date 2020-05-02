
public class Test {

	public static void main(String[] args) {
		Map myMap;
		
		try {
			myMap = new Map("map1.txt");
			Path thePath1 = new Path(myMap);
			thePath1.findPath();
			
			myMap = new Map("map2.txt");
			Path thePath2 = new Path(myMap);
			thePath2.findPath();
			
			myMap = new Map("map3.txt");
			Path thePath3 = new Path(myMap);
			thePath3.findPath();
			
			myMap = new Map("map4.txt");
			Path thePath4 = new Path(myMap);
			thePath4.findPath();
			
			myMap = new Map("map5.txt");
			Path thePath5 = new Path(myMap);
			thePath5.findPath();
			
			myMap = new Map("map6.txt");
			Path thePath6 = new Path(myMap);
			thePath6.findPath();
			
			myMap = new Map("map7.txt");
			Path thePath7 = new Path(myMap);
			thePath7.findPath();
			
			myMap = new Map("map8.txt");
			Path thePath8 = new Path(myMap);
			thePath8.findPath();

		} catch (Exception e) {
			System.out.println("Error reading input file.");
			System.out.println("Exception thrown by the virtual machine: " + e.getMessage());
		}
	}
	
}
