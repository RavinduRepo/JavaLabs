import java.util.ArrayList;
import java.util.Random; // for random 

// Import the FileWriter class to write to files
import java.io.*; // for file IO

class Sample { 
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
		int MAX = 45; // maximum attendence
		
		// we will run only if no exceptions were thrown 
		for(int i=0; i < names.length; i++) {
			if (names[i] != null){
				students.add(new Student(names[i], randomGen.nextInt(MAX))); 
			}
		}

		try {
			// Create new file for ineligible student's list
			FileWriter writer = new FileWriter("co225-classlist-ineligible.txt");

			for(Student student : students){
				student.updateSurname();	// Updating student's names
				if (student.isAttendanceLessThan80()){
					System.out.println(student.getSurname() + "\t" + student.getAttendancePercentage());	// Printing with the precentage attandence
					writer.write(student.getSurname() + "\n"); 	//	 Storing stundent's names in the new file
				}
			}
			writer.close(); // Closing the writer 
		} catch (IOException e) {
            System.out.println("An error occurred while copying text."); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        }
	}
}
