import java.util.Scanner;

public class Lab01PartC {

    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the month
        System.out.print("Enter the month: ");
        String month = scanner.nextLine();

        // Call the function to display the month value
        showMonthValue(month);
    }

    public static void showMonthValue(String month){
        // Define an array of months
        String[] months = {"JANUARY", "FEBRUARY", "MARCH",
                "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
                "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

        // Find the index of the entered month in the array
        int monthIndex = -1;
        for (int i = 0; i < months.length; i++){
            if (months[i].equals(month.toUpperCase())){
                monthIndex = i;
                break;
            }
        }

        // If the month was found in the array, print its number (index + 1)
        if (monthIndex != -1){
            System.out.println("The number of the month is: " + (monthIndex + 1));

            // Print all the months that come after the entered month
            for (int i = monthIndex + 1; i < months.length; i++){
                System.out.println(months[i]);
            }
        } else {
            // If the month was not found in the array, print an error message
            System.out.println("Invalid month entered.");
        }
    }
}
