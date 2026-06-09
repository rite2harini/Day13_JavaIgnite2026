CREATE DATABASE college_db;

USE college_db;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    marks INT
);

INSERT INTO students VALUES
(1,'Amit',80),
(2,'Riya',90),
(3,'Rahul',70),
(4,'Sneha',95),
(5,'Ankit',75);
import java.sql.*;

public class StudentDatabaseReportSystem {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "root";

        try {
            Connection con =
                    DriverManager.getConnection(url, user, password);

            // Calculate average marks
            String avgQuery = "SELECT AVG(marks) AS avg_marks FROM students";
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(avgQuery);

            double avgMarks = 0;

            if (rs1.next()) {
                avgMarks = rs1.getDouble("avg_marks");
            }

            System.out.println("Average Marks = " + avgMarks);
            System.out.println("\nStudents scoring above average:");

            // Fetch all students
            String query = "SELECT * FROM students";
            ResultSet rs2 = st.executeQuery(query);

            int count = 0;

            while (rs2.next()) {
                int id = rs2.getInt("id");
                String name = rs2.getString("name");
                int marks = rs2.getInt("marks");

                count++;

                if (marks > avgMarks) {
                    System.out.println(
                            id + " " + name + " " + marks);
                }
            }

            System.out.println("\nTotal Students Processed = " + count);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
