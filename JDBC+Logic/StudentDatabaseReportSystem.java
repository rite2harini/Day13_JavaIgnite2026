public class AboveAverageStudents {

	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/college_db";
	        String user = "root";
	        String password = "your_password";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(url, user, password);

	            // Step 1: Calculate average marks
	            String avgQuery = "SELECT AVG(marks) FROM students";
	            Statement st1 = con.createStatement();
	            ResultSet avgRs = st1.executeQuery(avgQuery);

	            double average = 0;

	            if (avgRs.next()) {
	                average = avgRs.getDouble(1);
	            }

	            System.out.println("Average Marks: " + average);

	            // Step 2: Fetch students above average
	            String studentQuery = "SELECT * FROM students";
	            Statement st2 = con.createStatement();
	            ResultSet rs = st2.executeQuery(studentQuery);

	            int totalStudents = 0;

	            System.out.println("\nStudents Scored Above Average:");

	            while (rs.next()) {
	                totalStudents++;

	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                double marks = rs.getDouble("marks");

	                if (marks > average) {
	                    System.out.println(id + " " + name + " " + marks);
	                }
	            }

	            System.out.println("\nTotal Students Processed: " + totalStudents);

	            con.close();

	        } catch (Exception e) {
	            System.out.println("Error: " + e);
	        }
	    }
	}

