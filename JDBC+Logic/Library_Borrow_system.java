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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryDatabaseSystem {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String password = "password";

        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            
            int bookId = Integer.parseInt(scanner.nextLine());

            String selectQuery = "SELECT available_copies FROM books WHERE book_id = ?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, bookId);
                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()) {
                    int copies = rs.getInt("available_copies");

                    if (copies > 0) {
                        String updateQuery = "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setInt(1, bookId);
                            updateStmt.executeUpdate();
                            System.out.println("Book Issued");
                        }
                    } else {
                        System.out.println("Not Available");
                    }
                } else {
                    System.out.println("Book not found");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
