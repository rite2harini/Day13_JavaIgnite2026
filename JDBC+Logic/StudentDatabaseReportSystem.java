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
import java.util.ArrayList;

public class StudentPerformanceAnalyzer {
    
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Step 1: Fetch all data using ResultSet
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            // Temporary storage for all students
            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Double> marksList = new ArrayList<>();
            
            // Collect all records and calculate total for average
            double totalMarks = 0;
            int count = 0;
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double marks = rs.getDouble("marks");
                
                ids.add(id);
                names.add(name);
                marksList.add(marks);
                
                totalMarks = totalMarks + marks;
                count++;
            }
            
            // Step 2: Calculate average marks
            double averageMarks = totalMarks / count;
            
            System.out.println("=== Student Performance Report ===");
            System.out.printf("Total Students Processed: %d%n", count);
            System.out.printf("Average Marks: %.2f%n%n", averageMarks);
            
            // Step 3: Filter and display students above average
            System.out.println("Students Scoring Above Average:");
            System.out.println("-------------------------------");
            System.out.printf("%-5s %-20s %-10s%n", "ID", "Name", "Marks");
            System.out.println("-------------------------------");
            
            int aboveAverageCount = 0;
            
            for(int i = 0; i < marksList.size(); i++) {
                if(marksList.get(i) > averageMarks) {
                    System.out.printf("%-5d %-20s %-10.2f%n", 
                                    ids.get(i), names.get(i), marksList.get(i));
                    aboveAverageCount++;
                }
            }
            
            System.out.println("-------------------------------");
            System.out.println("Students Above Average: " + aboveAverageCount + 
                             " out of " + count);
            
            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
