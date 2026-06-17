package JAVA_DAY_13;
import java.sql.*;

public class STUDENT_DATABASE_REPORT_SYSTEM {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/college_db";
        String username = "STWATRA";
        String password = "STWATRA123";

        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");          
            Connection con = DriverManager.getConnection(url, username, password);            
            String query = "SELECT * FROM students";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            double totalMarks = 0;
            int count = 0;

            
            while (rs.next()) {totalMarks += rs.getDouble("marks");
                count++;
            }

            double average = totalMarks / count;

            System.out.println("Average Marks = " + average);
            System.out.println();
            rs = st.executeQuery(query);

            System.out.println("Students Scoring Above Average:");
            System.out.println("--------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double marks = rs.getDouble("marks");

                if (marks > average) {
                    System.out.println("ID: " + id +", Name: " + name +", Marks: " + marks);
                }
            }

            System.out.println("\nTotal Students Processed: " + count);

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
