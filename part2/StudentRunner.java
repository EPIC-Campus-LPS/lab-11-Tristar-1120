package part2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentRunner {
    public static void main(String[] args) throws IOException{
        Scanner studentfile = new Scanner( new File("roster.csv"));
        int math = 0;
        int sci = 0;
        int his = 0;
        int eng = 0;
        int cs = 0;
        while (studentfile.hasNextLine()) {
            String data = studentfile.nextLine();
            String[] datalist = data.split(",");
            String studentID = datalist[0];
            String name = datalist[1];
            Student s = new Student(studentID, name);
            Scanner gradeFile = new Scanner(s.getGradeFile());
            gradeFile.nextLine();
            String[] gradeData = gradeFile.nextLine().split(": ");
            math += Integer.parseInt(gradeData[1]);
            gradeData = gradeFile.nextLine().split(": ");
            sci += Integer.parseInt(gradeData[1]);
            gradeData = gradeFile.nextLine().split(": ");
            his += Integer.parseInt(gradeData[1]);
            gradeData = gradeFile.nextLine().split(": ");
            eng += Integer.parseInt(gradeData[1]);
            gradeData = gradeFile.nextLine().split(": ");
            cs += Integer.parseInt(gradeData[1]);
        }
        System.out.println("Current Grades: \n- Math: " + math/16 + "\n- Science: " + sci/16 + "\n- History: " + his/16 + "\n- English: " + eng/16 + "\n- Computer Science: " + cs/16);
    }
}
