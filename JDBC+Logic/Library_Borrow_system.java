import java.sql.*;
import java.util.Scanner;
public class BookIssue {
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        try {
	           
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");

	           
	            System.out.print("Enter Book ID: ");
	            int bookId = sc.nextInt();

	           
	            PreparedStatement ps1 = con.prepareStatement(
	                    "SELECT available_copies FROM books WHERE book_id = ?");
	            ps1.setInt(1, bookId);

	            ResultSet rs = ps1.executeQuery();

	            if (rs.next()) {
	                int copies = rs.getInt("available_copies");

	                if (copies > 0) {
	                    
	                    PreparedStatement ps2 = con.prepareStatement(
	                            "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?");
	                    ps2.setInt(1, bookId);

	                    int rows = ps2.executeUpdate();

	                    if (rows > 0) {
	                        System.out.println("Book Issued");
	                    }
	                } else {
	                    System.out.println("Not Available");
	                }
	            } else {
	                System.out.println("Book ID Not Found");
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }

	        sc.close();
	    }
