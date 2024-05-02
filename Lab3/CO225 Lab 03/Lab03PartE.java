import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Lab03PartE {
    public static void main(String[] args) {
        // Read student data from file into a HashMap
        HashMap<String, String> studentMap = new HashMap<>();

        try {
            Scanner fileScanner = new Scanner(new File("StudentList"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                studentMap.put(parts[0], parts[1]);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Prompt user for input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter regNo or first letter of the name: ");
        String input = scanner.nextLine();
        scanner.close();  // closing the scanner

        if (input.length() > 1 && input.charAt(0) == 'E' && input.charAt(1) == '/'){ // consider the input as E_number input if starts with 'E/' 
            String IndexNumber = input;     // input is the index number
            // Search for the student by regNo
            if (studentMap.containsKey(IndexNumber)) {
                System.out.println("Name: " + studentMap.get(IndexNumber));
            } else {
                System.out.println("Student not found.");   // Print not found message
            }
        }
        else if (input.length() == 1){  // if input is one letter
            char firstLetter = input.charAt(0); // save the input as a char 
            System.out.printf("List of students starts with the letter '%s'\n", firstLetter);   // prints the title for student list

            int studentNotFound = 1;    // Flag to print the not found message
            for (String regNo : studentMap.keySet()){
                if (studentMap.get(regNo) != null && studentMap.get(regNo).charAt(0) == firstLetter){
                    System.out.printf("%s\t%s\n", studentMap.get(regNo), regNo);
                    studentNotFound = 0;
                }
            }
            if (studentNotFound == 1){
                System.out.printf("No student found with letter '%s'\n", firstLetter);   // prints the students not found message 
            }
        }
        else {
            System.out.println("Please enter a valid input");   // Print error message if the input is not in the standard format
        }
    }
}
