import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Student[] names=new Student[61];
        String[] surnamesArray =new String[62];
        File fileobj=new File("co225-classlist.txt");

        Scanner scanobj= null;
        try {
            scanobj = new Scanner(fileobj);

            int i=0;        //used to loop through the names array

            while (scanobj.hasNextLine()){

                String name1=scanobj.nextLine();            //reading and storing names from the file
                surnamesArray[i]=name1;             //storing surnames in this array
                names[i]= new Student(name1);
                names[i].surname=name1;
                i++;

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanobj.close();
        for (int i=0;i< names.length;i++){
            names[i].attendance= (int)(Math.random()*45);

        }
        for (int i=0;i< names.length;i++){
            double attendancePercentage=(names[i].attendance/45.0)*100.0;

            if (attendancePercentage<80.0){

                File newFile =new File("co225-classlist-ineligible.txt");
                try {
                    if (newFile.createNewFile()){           //create a new file as co225-classlist-ineligible.txt

                    }else{                                  //if file already exists this will execute

                        try {                       //writing to the file
                            FileWriter fileWriteobj = new FileWriter(newFile,true);
                            fileWriteobj.append(names[i].surname+"\n");
                            fileWriteobj.close();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                surnamesArray[i]=surnamesArray[i]+"-ineligible";


            }
        }
        //printing the ineligible list
        File newFile1 =new File("co225-classlist-ineligible.txt");
        Scanner newscanobj = null;
        try {
            newscanobj = new Scanner(newFile1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (newscanobj.hasNextLine()){

           System.out.println(newscanobj.nextLine());
        }
        newscanobj.close();


        //updating co225-classlist.txt

        FileWriter writerClassList=null;
        for (int j=0;surnamesArray[j]!=null;j++){
            if (surnamesArray[j]!=null){
                try {
                    //
                    fileobj.createNewFile();
                    if (j==0){
                        writerClassList=new FileWriter("co225-classlist.txt");      //remove previos data in first time
                    }else{
                        writerClassList=new FileWriter("co225-classlist.txt",true);     //keep the data in file
                    }

                    writerClassList.write(surnamesArray[j]+"\n");
                    writerClassList.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }

    }
}
