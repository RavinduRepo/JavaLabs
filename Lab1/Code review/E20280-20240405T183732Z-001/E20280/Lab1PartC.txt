import java.util.Objects;
import java.util.Scanner;

public class Lab01PartC {

    public static void main(String args[]) {
        //String month = "JANUARY"; // example
        System.out.println("Enter a month: ");
        Scanner myObj = new Scanner(System.in);
        String month = myObj.nextLine();
        //System.out.println(month);
        showMonthValue(month);
    }

    public static void showMonthValue(String month){
//        int monthValue =0;
        String[] Months_ = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOMBER","NOVEMBER","DECEMBER"};
        //Implement C a
        for(int i =0 ; i<12;i++){
            if (Objects.equals(month, Months_[i])) {
                System.out.println(i+1);
            }
        }
        
        //Implement C b
        for(int i =0 ; i<12;i++){
            if (Objects.equals(month, Months_[i])) {
                System.out.println(i+1);
                for (int j = i+1; j<12;j++){
                    System.out.println(Months_[j]);
                }
            }
        }


    }

}