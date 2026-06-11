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

import java.util.ArrayList;
import java.sql.*;

public class StudentDatabaseReportSystem {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String pass = "your_password";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String query = "SELECT id, name, marks FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<int[]> data = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            int total = 0;
            int sum = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                data.add(new int[]{id, marks});
                names.add(name);
                sum += marks;
                total++;
            }
            double avg = (double) sum / total;
            System.out.println("Average marks: " + avg);
            System.out.println("Total students processed: " + total);
            System.out.println("\nStudents above average:");
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i)[1] > avg) {
                    System.out.println("ID: " + data.get(i)[0] + " | Name: " + names.get(i) + " | Marks: " + data.get(i)[1]);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
