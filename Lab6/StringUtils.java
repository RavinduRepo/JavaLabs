import java.util.Scanner;

// StringUtils.java
/**
 * A utility class for performing common string operations.
 */
public class StringUtils {
    public static void main(String[] args) {

        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string to check if it is a Palindrome: ");
        String word = scanner.nextLine();

        // Close the scanner object
        scanner.close();

        // Check if the entered word is a palindrome and print the result
        if (isPalindrome(word)){
            System.out.println("The word you entered is a Palindrome");
        }
        if (!isPalindrome(word)){
            System.out.println("The word you entered is not a Palindrome");
        }

    }

    /**
     * Checks if a string is palindrome (reads the same backward as forward).
     *
     * @param str the string to check (should be not null)
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // If the string is a palindrome (i.e., it is equal to its reverse), return true
        if (str.equals(reverse(str))){
            return true;
        }
        // If the string is not a palindrome, return false
        return false;
    }

    /**
     * Reverses the order of characters in a string.
     *
     * @param str the string to reverse (should be not null)
     * @return the reversed string
     */
    public static String reverse(String str) {
        // If the input string is null or empty, throw an IllegalArgumentException
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input: Input cannot be null or empty");
        }
        // Otherwise, reverse the string and return the result
        else {
            return new StringBuilder(str).reverse().toString();
        }
    }
    
}
