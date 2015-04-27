import java.util.Scanner;


public class LibraryDriver {
	//enum for the switch case if you wish. Using if-else has no harm at all.
    /*
    public enum OperationType{
        INSERT("insert"), FIND("find"), REMOVE("remove");
        private String type;
        OperationType(String type){
            this.type = type;
        }
        //you can also override a toString instead of brutely return the value
        public String getType(){
            return this.type;
        }
    };
    */
	
	// Main method
	public static void main(String[] args) {
        
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
        
		// Initialize array of results and binary search tree
		String[] results = new String[num];
		BST bst = new BST();
        
		for (int i = 0; i < num; ++i) {
			String operationType = s.nextLine();
			String title = s.nextLine();
			// Perform specified operation and add to results
			if (operationType.equals("insert")) {
                if (bst.insert(title))
                    results[i] = "Inserted " + title + " into the catalog.";
                else
                    System.err.println("This shouldn't happen according to the input file format");
			}
			
			else if (operationType.equals("find")) {
				if (bst.find(title))
					results[i] = title + " is in the catalog.";
				else
					results[i] = title + " is not in the catalog.";
			}
			
			else if (operationType.equals("remove")) {
				if (bst.remove(title))
					results[i] = title + " was removed from the catalog.";
				
				else
					results[i] = title + " is not in the catalog.";
				
			}
			
		}
		s.close();
		for (String result : results) {
            //what happens if we output to stderr?
			System.out.println(result);
		}
		bst.print();
		
		
		
		
		
	}
}
