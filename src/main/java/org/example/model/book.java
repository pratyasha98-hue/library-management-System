package org.example.model;

public class book {

    private  static String title;
    private  static int quantity;
    private  static int book_id;
    private  static String author;

    //constructor
    public book(String title,String author, int quantity){
        this.title = title;
        this.quantity = quantity;
        this.author = author;
    }
    
    //getters
    public static String getTitle() {
        return title;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static int getBook_id() {
        return book_id;
    }

    public static String getAuthor() {
        return author;
    }
}
