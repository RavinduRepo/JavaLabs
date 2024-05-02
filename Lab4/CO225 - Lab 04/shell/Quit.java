// This class represents a command to quit the program, extending a generic command class.

public class Quit extends GenericCommand { 

    // Method to handle the quit command
    public void handleCommand(String [] args) { 

        // Check if the first argument is not "quit"
	    if(!args[0].equals("quit")) someThingWrong(); // If not "quit", something is wrong

        // Check if the number of arguments length is not 1
	    if(args.length != 1) { 
	        System.out.println("Usage: quit"); // Display usage message
	        return; // Return from the method
	    }

	    // Print the number of commands executed since starting
	    System.out.printf("Executed %d commands since starting", Shell.commandCount);

	    /* OK, so just die */ 
	    System.exit(0); // Terminate the program with exit code 0
    }

}
