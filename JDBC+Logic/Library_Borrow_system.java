/*
Create a Java program connected to database library_db.

Table:

book_id
title
available_copies
Task:
Allow user to input a book ID
Check availability
If available:
Reduce copy count by 1
Print “Book Issued”
Else:
Print “Not Available”
Hint:

Think:

SELECT → check condition
UPDATE → modify data
Use if-else inside Java after ResultSet
*/
import java.sql.*;
import java.util.Scanner;

public class LibraryManager {
    
    // Database connection details
    static final String URL = "jdbc:mysql://localhost:3306/library_db";
    static final String USER = "root";
    static final String PASSWORD = "password";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();
            
            // SELECT query to check availability
            String selectQuery = "SELECT title, available_copies FROM books WHERE book_id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, bookId);
            ResultSet rs = selectStmt.executeQuery();
            
            // Check if book exists and check condition
            if(rs.next()) {
                String title = rs.getString("title");
                int availableCopies = rs.getInt("available_copies");
                
                // If-else logic for availability
                if(availableCopies > 0) {
                    // UPDATE to modify data - reduce copy count by 1
                    String updateQuery = "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                    updateStmt.setInt(1, bookId);
                    
                    int rowsAffected = updateStmt.executeUpdate();
                    
                    if(rowsAffected > 0) {
                        System.out.println("Book Issued Successfully!");
                        System.out.println("Title: " + title);
                        System.out.println("Remaining Copies: " + (availableCopies - 1));
                    }
                    
                    updateStmt.close();
                    
                } else {
                    System.out.println("Not Available");
                    System.out.println("Title: " + title + " (All copies are currently issued)");
                }
                
            } else {
                System.out.println("Book Not Found with ID: " + bookId);
            }
            
            // Close resources
            rs.close();
            selectStmt.close();
            conn.close();
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
