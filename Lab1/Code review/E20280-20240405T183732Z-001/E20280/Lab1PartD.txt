import java.time.LocalDate;
import java.time.Period;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lab01PartD {

    public static void main(String args[]) {

        //int countryCode = 1; // example
        //String birthDate = "1999/09/19"; // example
        System.out.println("Enter the country code : ");
        Scanner myObj = new Scanner(System.in);
        int countryCode = myObj.nextInt();

        System.out.println("Enter the birthday : ");
        Scanner myObj1 = new Scanner(System.in);
        String birthDate = myObj1.nextLine();
        // Implement D - Calculate age in years
        String[] date__ = birthDate.split("/",3);

        //System.out.println(date__[2]);
        int year = Integer.parseInt(date__[0]);
        int month = Integer.parseInt(date__[1]);
        int day = Integer.parseInt(date__[2]);


        LocalDate date_now = LocalDate.now();
        LocalDate date_req = LocalDate.of(year,month,day);
        int age = Period.between(date_req, date_now).getYears();
        //System.out.println(age);
        //int age = 0;

        showTicketPrice(countryCode , age);
    }

    public static void showTicketPrice(int CountryCode , int age){

        //implement D - Calculate ticket price and show ticket price
        float ticket_price = 200;
        float pay_amount = 0;
        float discount = 0;
        if(age < 5){
            pay_amount =0;
        }else if (age>=65){
            discount = 200 *50/100 ;
            pay_amount = ticket_price - discount;

        } else if (CountryCode == 7) {
            pay_amount = ticket_price;
        } else if (CountryCode < 7) {
            float extra = ticket_price*35/100;
            pay_amount = ticket_price +extra;
        }else {
            float extra = ticket_price*65/100;
            pay_amount = ticket_price +extra;
            
        }
        System.out.printf("Ticket price is Rs. %.2f \n",pay_amount );
    }

}