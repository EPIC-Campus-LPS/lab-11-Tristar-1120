package part2;
import java.io.File;
import java.io.IOException;

public class Student {
    private final String studentID;
    private final String name;
    private File gradeFile;

    public Student(String studentID, String name) throws IOException {
        this.studentID = studentID;
        this.name = name;
        this.gradeFile = new File("student_grades/" + studentID + "_grades.txt");
    }

    public Student(String studentID, String name, File gradeFile) {
        this.studentID = studentID;
        this.name = name;
        this.gradeFile = gradeFile;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public File getGradeFile() {
        return gradeFile;
    }

    public void setGradeFile(File newFile) {
        gradeFile = newFile;
    }
}
