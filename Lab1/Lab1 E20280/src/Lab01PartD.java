import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab01PartD {
    // Constants for ticket price calculation
    private static final int SAARC_COUNTRY_CODE_START = 1;
    private static final int SAARC_COUNTRY_CODE_END = 6;
    private static final int OTHER_COUNTRY_CODE = 7;
    private static final float BASE_PRICE = 200f;
    private static final float SAARC_COUNTRY_MULTIPLIER = 1.35f;
    private static final float OTHER_COUNTRY_MULTIPLIER = 1.65f;

    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner scanner = new Scanner(System.in);

        // Read the country code from the user
        System.out.print("Enter the country code: ");
        int countryCode = Integer.valueOf(scanner.nextLine());

        // Read the birth date from the user
        System.out.print("Enter the Birth-Day(yyyy/mm/dd): ");
        String birthDate = scanner.nextLine();

        // Parse the birth date and calculate the age
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDateObj = LocalDate.parse(birthDate, format);
        LocalDate currentDate = LocalDate.now();
        Period dateDiff = Period.between(birthDateObj, currentDate);
        int age = dateDiff.getYears();

        // Calculate and show the ticket price
        showTicketPrice(countryCode , age);
    }

    public static void showTicketPrice(int countryCode , int age){
        // Start with the base price
        float price = BASE_PRICE;

        // Adjust the price based on the age and country code
        if (age <= 5){
            // Free for children under 5
            price = 0f;
        }
        else if (age >= 65){
            // Half price for seniors
            price = price * 0.5f;
        }
        else {
            // Different multipliers for SAARC countries and other countries
            if (countryCode >= SAARC_COUNTRY_CODE_START && countryCode <= SAARC_COUNTRY_CODE_END){
                price = price * SAARC_COUNTRY_MULTIPLIER;
            }
            else if (countryCode != OTHER_COUNTRY_CODE){
                price = price * OTHER_COUNTRY_MULTIPLIER;
            }
        }

        // Print the final ticket price
        System.out.printf("Ticket Price is: %.2f", price);
    }
}
