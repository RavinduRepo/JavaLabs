import java.util.Scanner;

public class Lab01PartB {

    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = Integer.valueOf(scanner.nextLine());

        // Call the function to determine if the number is even or odd
        findEvenOrOdd(number);
    }

    public static void findEvenOrOdd(int number){
        // Initialize a variable to keep track of whether the number is even or odd
        int isOdd = 0;
        //Impliment B a
        // Check if the number is even or odd
        if (number % 2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
            isOdd = 1;
        }
        //Implement B b
        // If the number is even, print the next 5 even numbers
        // If the number is odd, print the next 3 odd numbers
        if (isOdd == 0){
            for (int i = 1; i <= 5; i++){
                System.out.println(number + i * 2);
            }
        } else {
            for (int i = 1; i <= 3; i++){
                System.out.println(number + i * 2);
            }
        }
    }
}
