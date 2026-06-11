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

import java.util.Scanner;
import java.sql.*;
public class Library_Borrow_system {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String pass = "your_password";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        int bookId = sc.nextInt();

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String query = "SELECT available_copies FROM books WHERE book_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int copies = rs.getInt("available_copies");

                if (copies > 0) {
                    String update = "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?";
                    PreparedStatement ps2 = con.prepareStatement(update);
                    ps2.setInt(1, bookId);
                    ps2.executeUpdate();

                    System.out.println("Book Issued");
                } else {
                    System.out.println("Not Available");
                }

            } else {
                System.out.println("Book not found");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}