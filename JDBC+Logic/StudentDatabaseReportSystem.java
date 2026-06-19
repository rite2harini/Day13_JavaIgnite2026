/*
Create a Java program that connects to a MySQL database college_db.

The table students contains:

id
name
marks
Task:
Fetch all student records
Display only students who scored above average marks
Also print total number of students processed
Hint:

Think in steps:

Fetch all data using ResultSet
First calculate average marks
Then filter while reading result
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class StudentRecord {
    int id;
    String name;
    int marks;

    public StudentRecord(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class CollegeDatabaseAnalyzer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "password";

        ArrayList<StudentRecord> students = new ArrayList<>();
        int totalMarks = 0;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, marks FROM students")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                
                students.add(new StudentRecord(id, name, marks));
                totalMarks += marks;
            }

            int totalStudents = students.size();
            
            if (totalStudents > 0) {
                double average = (double) totalMarks / totalStudents;
                
                System.out.println("Total students processed: " + totalStudents);
                System.out.println("Students scoring above average (" + average + "):");
                
                for (StudentRecord student : students) {
                    if (student.marks > average) {
                        System.out.println(student.name + " (" + student.marks + " marks)");
                    }
                }
            } else {
                System.out.println("No records found in database.");
            }

        } catch (SQLException e) {
            System.out.println("Database error");
        }
    }
}
