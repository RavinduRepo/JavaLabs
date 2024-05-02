import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab03PartB
{
    public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);  // creating the scanner object
        int index = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the index: ");  // printing the message to the terminal
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();  // discard the invalid input
            }
        }
        System.out.println("Adjacents By Array:");
        findAdjacentsByArray(index);
        System.out.println();
        System.out.println("Adjacents By Map:");
        findAdjacentsByMap(index);
        scanner.close();  // closing the scanner
    }

	
	public static void findAdjacentsByArray(int index){
		// check if the index is not in a range where there are not even adjacent letters
		if (0 >= index || index -2 >= 26) {
			System.out.printf("<Null,Null>,<Null,Null>");
		} else {
			// creating the letters array
			char[] alphabet = new char[26];
			for (char letter = 'A'; letter <= 'Z'; letter++) {
				alphabet[letter - 'A'] = letter;
			}
			// check if the both adjacents are within the index reange
			if (0 < index - 2 && index < 26){
				System.out.printf("<%d,%s>,<%d,%s>", index - 1, alphabet[index - 2], index + 1, alphabet[index]);
			}
			else if (0 >= index - 2){
				System.out.printf("<Null,Null>,<%d,%s>", index + 1, alphabet[index]);
			}
			else if (index >= 26){
				System.out.printf("<%d,%s>,<Null,Null>", index - 1, alphabet[index - 2]);
			}
		}
	}
	
	public static void findAdjacentsByMap(int index)
	{
		// check if the index is not in a range where there are not even adjacent letters
		if (0 >= index || index -2 >= 26) {
			System.out.printf("<Null,Null>,<Null,Null>");
		} else {
			// creating the letters array
			Map<Integer, Character> alphabetMap = new HashMap<Integer, Character>();
			for (char letter = 'A'; letter <= 'Z'; letter++) {
				int letterIndex = letter - 'A' + 1;
				alphabetMap.put(letterIndex, letter);
			}
			// check if the both adjacents are within the index reange
			if (0 < index - 2 && index < 26){
				System.out.printf("<%d,%s>,<%d,%s>", index - 1, alphabetMap.get(index - 1), index + 1, alphabetMap.get(index + 1));
			}
			else if (0 >= index - 2){
				System.out.printf("<Null,Null>,<%d,%s>", index + 1, alphabetMap.get(index + 1));
			}
			else if (index >= 26){
				System.out.printf("<%d,%s>,<Null,Null>", index - 1, alphabetMap.get(index - 1));
			}
		}
    }
}
	