import java.sql.*;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library_db";
        String username = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Read Book ID
            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();

            // SELECT query to check availability
            String selectQuery =
                    "SELECT available_copies FROM books WHERE book_id = ?";

            PreparedStatement ps1 = con.prepareStatement(selectQuery);
            ps1.setInt(1, bookId);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                int availableCopies = rs.getInt("available_copies");

                if (availableCopies > 0) {

                    // UPDATE query to reduce copies by 1
                    String updateQuery =
                            "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?";

                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setInt(1, bookId);

                    int rows = ps2.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Book Issued");
                    }

                    ps2.close();

                } else {
                    System.out.println("Not Available");
                }

            } else {
                System.out.println("Book ID Not Found");
            }

            rs.close();
            ps1.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}/*
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
