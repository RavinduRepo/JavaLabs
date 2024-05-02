// Import the File class to work with files
import java.io.File;

// Import this class for handling file not found errors
import java.io.FileNotFoundException;

// Import the Scanner class to read content from text files
import java.util.Scanner;

// This class represents a command to display the content of a file, extending a generic command class
public class Less extends GenericCommand { 

    // Static variable to keep track of the number of commands executed
    public static int commandCount = 0;

    // Method to handle the less command
    public void handleCommand(String [] args) { 

        // Check if the first argument is not "less"
	    if(!args[0].equals("less")) someThingWrong(); // If not "less", something is wrong

        // Check if the number of arguments length is not 2
	    if(args.length != 2) { 
	        System.out.println("Usage: less <File_Name.extention>"); // Display usage message
	        return; // Return from the method
	    }

        // Try to read the file and display its content
        try {
            // Create a File object with the specified file name
            File MyFile = new File(args[1]);
            // Create a Scanner object to read from the file
            Scanner Reader = new Scanner(MyFile);
            // Read and print each line of the file
            while (Reader.hasNextLine()){
                String data = Reader.nextLine();
                System.out.println(data);
            }
            // Close the Scanner object
            Reader.close();
        }
        // Catch FileNotFoundException if the file is not found
        catch (FileNotFoundException e){
            System.out.println("The file is not found!"); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        }
	
    }

}
