import java.util.ArrayList;
import java.util.Random; // for random 

// Import the FileWriter class to write to files
import java.io.*; // for file IO

class Main { 
    /* contains some sample code which might be useful for the lab */

    public static void main(String [] args) { 

		BufferedReader descriptor = null; 
		String [] names = new String[62]; // 61 names 
		try { 
			descriptor = new BufferedReader(
					new FileReader("co225-classlist.txt"));

			for(int i=0; i < names.length; i++) // assume file has 61 lines 
			names[i] = descriptor.readLine(); 

			descriptor.close(); 

		} catch(IOException e) { 
			// IOException is more generic (FileNotFound is a type of a 
			// IOException, so catching only that is sufficient 
			System.out.println("Bad things happen, what do you do!" + e);
			return; 
		}

		ArrayList<Student> students = new ArrayList<>();	// Store students objecs
		Random randomGen = new Random(); // To generte an attendence
		int maxAttendence = 45; // maximum attendence
		
		// we will run only if no exceptions were thrown 
		for(int i=0; i < names.length; i++) {
			if (names[i] != null){
				students.add(new Student(names[i], randomGen.nextInt(maxAttendence))); 
			}
		}

		try {
			// Create new file for ineligible student's list
			FileWriter writer1 = new FileWriter("co225-classlist-ineligible.txt");
			FileWriter writer2 = new FileWriter("co225-classlist.txt");


			for(Student student : students){
				if (student.isAttendanceLessThan80()){
					writer1.write(student.getSurname() + "\n"); 	//	 Storing stundent's names in the new file
					student.updateSurname();	// Updating student's names
				}
				System.out.println(student.getSurname() + "     \t" + student.getAttendancePercentage());	// Printing with the precentage attandence
				writer2.write(student.getSurname() + "\n");
			}
			writer1.close(); // Closing the writer 
			writer2.close(); // Closing the writer 

		} catch (IOException e) {
            System.out.println("An error occurred while copying text."); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        }
	}
}
