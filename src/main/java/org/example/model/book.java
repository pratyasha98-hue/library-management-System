package org.example.model;

public class book {

    private  String title;
    private  int quantity;
    private  int book_id;
    private  String author;

    //constructor
    public book(String title,String author, int quantity){
        this.title = title;
        this.quantity = quantity;
        this.author = author;
    }
    
    //getters
    public String getTitle() {
        return title;
    }

    public  int getQuantity() {
        return quantity;
    }

    public  int getBook_id() {
        return book_id;
    }

    public  String getAuthor() {
        return author;
    }
}
