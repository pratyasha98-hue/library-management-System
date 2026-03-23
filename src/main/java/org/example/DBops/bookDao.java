package org.example.DBops;
import org.example.model.book;
import org.example.databaseConnectivity.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bookDao {
    public static void addBook(book Book){
        try{
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO BOOKS(title, author, quantity) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());

            ps.executeUpdate();

            System.out.println("Book added successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void viewBooks() {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM books";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + "|"
                        + rs.getString("title") + "|" +
                        rs.getString("author") + "|" +
                        rs.getInt("quantity"));
            }

            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteBook(int book_id){

        try{
                Connection conn = DBConnection.getConnection();
                String query = "DELETE FROM books WHERE book_id =?";

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, book_id);
                int rows = ps.executeUpdate();

                if(rows>0){
                    System.out.println("Book deleted successfully!");
                }else{
                    System.out.println("Book not found!");
                }

        }catch(Exception e){
                e.printStackTrace();
        }
    }
}

