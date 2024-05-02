//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lab01PartA{

    public static void main(String args[]) {
        int marks = 67; // example
        showGrade(marks);
    }

    public static void showGrade(int marks){
        //Implement A
        switch ((int)(marks/5)) {
            case 20,19,18,17,16:
                System.out.println('A');
                break;
            case 15,14,13:
                System.out.println('B');
                break;
            case 11,12:
                System.out.println('C');
                break;
            case 10:
                System.out.println('D');
                break;

            default:
                System.out.println('E');
                break;

        }
    }

}