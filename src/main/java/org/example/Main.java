package org.example;

import org.example.DBops.IssueDao;
import org.example.DBops.MemberDAO;
import org.example.databaseConnectivity.DBConnection;

import java.sql.SQLOutput;
import java.util.Scanner;

import org.example.model.Member;
import org.example.model.book;
import org.example.DBops.bookDao;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("----Welcome to Library System----");
            System.out.println("1: Add a book");
            System.out.println("2: View Books");
            System.out.println("3: Delete a book");
            System.out.println("4: Issue a book");
            System.out.println("5: Register yourself as a member!");
            System.out.println("6: See all members");
            System.out.println("7: Exit");

            System.out.println("press a number to Continue: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.println("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    book book = new book(title, author, quantity);
                    bookDao.addBook(book);
                    break;
                case 2:
                    System.out.println("-----Catalogue-----");
                    bookDao.viewBooks();
                    break;
                case 3:
                    System.out.println("Enter the book_id to delete: ");
                    int id = sc.nextInt();
                    bookDao.deleteBook(id);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Enter the book_id to issue: ");
                    int bookid = sc.nextInt();
                    System.out.println("Enter your library id: ");
                    int lid = sc.nextInt();
                    IssueDao.issueBook(bookid, lid);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Welcome! Enter your first name: ");
                    String f_name = sc.nextLine();
                    System.out.println("Enter your last name: ");
                    String l_name = sc.nextLine();
                    System.out.println("Enter your phone number: ");
                    long phone_num = sc.nextLong();
                    Member newMem = new Member(f_name, l_name, phone_num);
                    MemberDAO.addMember(newMem);
                    break;
                case 6:
                    System.out.println("Existing members: ");
                    MemberDAO.viewMember();
                    break;
                case 7:
                    System.out.println("Thank you for visiting, Bye");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}