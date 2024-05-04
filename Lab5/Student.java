import java.io.*;
import java.util.Random;

public class Student {
    private String surname;
    private int attendance;
    private static int studentCount = 0;
    private static double totalAttendene = 0;

    public Student(String surname, int attendance) {
        this.surname = surname;
        this.attendance = attendance;
        Student.totalAttendene += attendance;
        Student.studentCount += 1;
    }

    // Method to calculate attendance percentage of a student
    public double getAttendancePercentage() {
        return (double) attendance / 45 * 100;
    }

    // Method to calculate average attendence percentage of all students
    public static double avrgAttendancePercentageofAllStudents() {
        return (totalAttendene / studentCount)/ 45 * 100;
    }

    // Getter method for surname
    public String getSurname() {
        return surname;
    }

    // Method to update surname if attendance is less than 80%
    public void updateSurname() {
        if (isAttendanceLessThan80()) {
            this.surname += "-ineligible";
        }
    }

    // Method to check if student's attendance is less than 80%
    public boolean isAttendanceLessThan80() {
        return getAttendancePercentage() < 80;
    }
}
