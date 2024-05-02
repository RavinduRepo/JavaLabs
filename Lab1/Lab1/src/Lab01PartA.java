import java.util.Scanner;

public class Lab01PartA {

    public static void main(String[] args) {
        // Example marks for testing
        int marks = 100;
        // Call the function to display the grade
        showGrade(marks);
    }
    public static void showGrade(int marks){
        // Determine the grade based on the marks
        // 1 for A, 2 for B, 3 for C, 4 for D, 5 for F
        int grade =
                (marks <= 100 && marks >=80)? 1:
                        (marks <= 79 && marks >=65)? 2:
                                (marks <= 64 && marks >=55)? 3:
                                        (marks <= 54 && marks >=50)? 4: 5;

        // Display the grade based on the calculated grade value
        switch (grade){
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            case 4:
                System.out.println("D");
                break;
            case 5:
                System.out.println("F");
                break;
        }
    }
}
