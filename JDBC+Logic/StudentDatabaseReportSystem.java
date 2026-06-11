import java.sql.*;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentsAboveAverage {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "root";

        ArrayList<Student> students = new ArrayList<>();
        int totalStudents = 0;
        int sumMarks = 0;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Fetch all records
            String query = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Read all records and calculate total marks
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                students.add(new Student(id, name, marks));

                sumMarks += marks;
                totalStudents++;
            }

            // Calculate average marks
            double average = (double) sumMarks / totalStudents;

            System.out.println("Average Marks = " + average);
            System.out.println("\nStudents Scoring Above Average:");

            // Display students above average
            for (Student s : students) {
                if (s.marks > average) {
                    System.out.println(
                        "ID: " + s.id +
                        ", Name: " + s.name +
                        ", Marks: " + s.marks
                    );
                }
            }

            // Display total students processed
            System.out.println("\nTotal Students Processed: " + totalStudents);

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}/*
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
