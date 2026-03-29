package org.example.DBops;

import org.example.databaseConnectivity.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueDao {
    public static void issueBook(int book_id, int library_id){
        try{
            Connection conn = DBConnection.getConnection();

            String checkQuery = "SELECT quantity FROM books WHERE book_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(checkQuery);
            ps1.setInt(1, book_id);

            ResultSet rs = ps1.executeQuery();

            if(rs.next()){
                int quantity = rs.getInt("quantity");

                if(quantity > 0){
                    String issueQuery = "INSERT INTO issued_books(book_id, library_id, issue_date) VALUES(?, ?, CURDATE())";
                    PreparedStatement ps2 = conn.prepareStatement(issueQuery);
                    ps2.setInt(1, book_id);
                    ps2.setInt(2, library_id);

                    ps2.executeUpdate();

                    //reduce quantity
                    String updateQuery = "UPDATE books SET quantity = quantity -1 WHERE book_id = ?";
                    PreparedStatement ps3 = conn.prepareStatement(updateQuery);

                    ps3.setInt(1, book_id);
                    ps3.executeUpdate();

                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book out of the stock!");
                }
            }else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
