import java.util.Scanner;

public class Lab03PartA
{
    public static void main(String args[])
    {
		System.out.println("Enter the number of rows: ");		// printing the massage to the terminal
		Scanner scanner = new Scanner(System.in); 	// creating the scanner object
		int rows = scanner.nextInt();
		scanner.close();	// closing the scanner

		int[] triangleNumbers = new int[rows]; //array of integers to hold tiangle numbers upto number of rows
		for (int i = 0; i < rows; i++){	// calculatn the triangle numbers
			triangleNumbers[i] = (rows - i) * (rows - i + 1) / 2;
		}

		for (int j = 0; j < rows; j++){		// printing the numbers
			for (int k = 0; k <= j; k++){
				System.out.printf("%d\t", triangleNumbers[k] - j + k);
			}
			System.out.println();
		}
	}
}
	