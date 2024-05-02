import java.util.Scanner;

public class Lab01PartB {

    public static void main(String args[]) {
        int number = 3; // example
        findEvenOrOdd(number);

        System.out.println("Enter a number: ");
        Scanner myObj = new Scanner(System.in);
        int number1 = myObj.nextInt();

        findEvenOrOdd(number1);
    }

    public static void findEvenOrOdd(int number){
        //Implement B a
        if(number%2 == 0){
            System.out.println("Even number");
            
        }else{
            System.out.println("Odd number");
            
        }
        

        //Implement B b
        int next_even=0;
        int next_odd = 0;

        if(number%2 == 0){
            System.out.println("Even number");
            for(int i = 0; i<5;i++){
                next_even = number +2*(i+1);
                System.out.printf("Next even number: %d\n",next_even);
            }
        }else{
            System.out.println("Odd number");
            for (int i=0; i<3; i++){
                next_odd = number +2*(i+1);
                System.out.printf("Next odd number: %d\n",next_odd);
            }
        }

    }

}