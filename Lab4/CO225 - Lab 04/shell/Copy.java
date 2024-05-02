// Import the FileWriter class to write to files
import java.io.FileWriter;

// Import the File class to work with files
import java.io.File;

// Import this class for handling file not found errors
import java.io.FileNotFoundException;

// Import the IOException class to handle IO errors
import java.io.IOException;

// Import the Scanner class to read content from text files
import java.util.Scanner;

// This class represents a command to copy text from one file to another, extending a generic command class
public class Copy extends GenericCommand {

    // Static variable to keep track of the number of commands executed
    public static int commandCount = 0;

    // Method to handle the copy command
    public void handleCommand(String[] args) {

        // Check if the first argument is not "copy"
        if (!args[0].equals("copy")) {
            someThingWrong(); // If not "copy", something is wrong
            return; // Return from the method
        }

        // Check if the number of arguments is not 3
        if (args.length != 3) {
            System.out.println("Usage: less <Source_File.extension> <Destination_File.extension>"); // Display usage message
            return; // Return from the method
        }

        // Try to create the destination file
        try {
            File destFile = new File(args[2]);
            if (destFile.createNewFile()) {
                System.out.println("File created: " + destFile.getName()); // Display message if file is created
            } else {
                System.out.println("File already exists."); // Display message if file already exists
            }
        } catch (IOException e) {
            System.out.println("An error has occurred."); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        }

        // Try to copy text from source file to destination file
        try {
            // Create a File object for the source file
            File srcFile = new File(args[1]);
            // Create a Scanner object to read from the source file
            Scanner reader = new Scanner(srcFile);
            // Create a FileWriter object to write to the destination file
            FileWriter writer = new FileWriter(args[2]);
            // Read each line from source file and write it to destination file
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                writer.write(data + "\n");
            }
            // Close the Scanner and FileWriter objects
            reader.close();
            writer.close();
            System.out.println("Text copied successfully."); // Display success message
        } catch (FileNotFoundException e) {
            System.out.println("The source file is not found!"); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        } catch (IOException e) {
            System.out.println("An error occurred while copying text."); // Display error message
            e.printStackTrace(); // Print stack trace for debugging
        }

    }
}
