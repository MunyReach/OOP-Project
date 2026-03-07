//Note to team: Java doesn't allow statements that exist outside a constructor or method like that directly in class body. So we delete Booksettings.java and add missing fields there.

package bookstore.book;

import java.util.ArrayList;

import bookstore.Book;

public class BookInfoHolder {
   //use arraylist instead 
    private ArrayList<Book> books;

    public BookInfoHolder() {

        books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 10.99, "Classic"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", 7.99, "Fiction"));
        books.add(new Book("1984", "George Orwell", "978-0451524935", 9.99, "Dystopian"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i+1) + ". ");
            books.get(i).displayInfo();
        }
    }
}