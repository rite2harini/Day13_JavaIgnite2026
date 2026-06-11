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

import java.sql.*;

public class StudentAnalysis {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String avgQuery = "SELECT AVG(marks) AS avg_marks FROM students";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(avgQuery);

            double average = 0;

            if (rs1.next()) {
                average = rs1.getDouble("avg_marks");
            }

            String selectQuery = "SELECT * FROM students";
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(selectQuery);

            int count = 0;

            while (rs2.next()) {
                count++;

                int id = rs2.getInt("id");
                String name = rs2.getString("name");
                int marks = rs2.getInt("marks");

                if (marks > average) {
                    System.out.println(id + " " + name + " " + marks);
                }
            }

            System.out.println("Total Students Processed = " + count);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
