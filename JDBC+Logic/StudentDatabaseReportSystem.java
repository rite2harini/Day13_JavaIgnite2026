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

public class StudentReport {
	 public static void main(String[] args) {

	        try {
	          
	            Class.forName("com.mysql.cj.jdbc.Driver");

	          
	            Connection con = DriverManager.getConnection(
	            	    "jdbc:mysql://localhost:3306/college_db", "root", "");

	          
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM students");

	            ArrayList<Student> list = new ArrayList<>();

	            int totalMarks = 0;
	            int count = 0;

	          
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                int marks = rs.getInt("marks");

	                list.add(new Student(id, name, marks));

	                totalMarks += marks;
	                count++;
	            }

	       
	            double average = (double) totalMarks / count;

	            System.out.println("Average Marks = " + average);

	            System.out.println("\nStudents Scoring Above Average:");

	       
	            for (Student s : list) {
	                if (s.marks > average) {
	                    System.out.println(
	                            s.id + " " + s.name + " " + s.marks);
	                }
	            }

	            System.out.println("\nTotal Students Processed = " + count);

	            con.close();

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
