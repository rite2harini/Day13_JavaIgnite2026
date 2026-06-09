CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    available_copies INT
);

INSERT INTO books VALUES
(101,'Java Programming',5),
(102,'Python Basics',0),
(103,'Database Systems',3);
import java.sql.*;
import java.util.Scanner;

public class LibraryBorrowSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        String url = "jdbc:mysql://localhost:3306/library_db";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String selectQuery =
                    "SELECT available_copies FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int copies = rs.getInt("available_copies");

                if (copies > 0) {

                    String updateQuery =
                            "UPDATE books SET available_copies = available_copies - 1 WHERE book_id=?";

                    PreparedStatement ps2 =
                            con.prepareStatement(updateQuery);

                    ps2.setInt(1, bookId);

                    ps2.executeUpdate();

                    System.out.println("Book Issued");
                } else {
                    System.out.println("Not Available");
                }

            } else {
                System.out.println("Book ID not found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
