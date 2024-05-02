import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab03PartD {
    public static void main(String[] args) {
        // Read student data from file into ArrayLists
        ArrayList<String> regNos = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File("StudentList"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                regNos.add(parts[0]);
                names.add(parts[1]);
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

        if (input.length() > 1 && input.charAt(0) == 'E' && input.charAt(1) == '/'){ // consider the inout as E_number input if starts with 'E/' 
            String IndexNumber = input;     // input is the index number
            // Search for the student by regNo
            int index = -1;
            for (int i = 0; i < regNos.size(); i++) {
                if (regNos.get(i) != null && regNos.get(i) .equalsIgnoreCase(IndexNumber)) {
                    index = i;
                    break;
                }
            }

            // Print the result
            if (index != -1) {
                System.out.println("Name: " + names.get(index) );
            } else {
                System.out.println("Student not found.");   // Print not found massage
            }
        }
        else if (input.length() == 1){  // if input is one letter
            char firstLetter = input.charAt(0); // save the input as a char 
            System.out.printf("List of students starts with the letter '%s'\n", firstLetter);   // prints the titel for student list

            int studentNotFound = 1;    // Flag to print the not found massage
            for (int i = 0; i < regNos.size() - 2; i++){
                if (names.get(i)  != null && names.get(i) .charAt(0) == firstLetter){
                    System.out.printf("%s\t%s\n", names.get(i) , regNos.get(i) );
                    studentNotFound = 0;
                }
            }
            if (studentNotFound == 1){
                System.out.printf("No stuent found with letter '%s'\n", firstLetter);   // prints the estundets not found massage 
            }
        }
        else {
            System.out.println("Please enter a valid input");   // Print error massagge if the input is not in the standard format
        }
    }
}


