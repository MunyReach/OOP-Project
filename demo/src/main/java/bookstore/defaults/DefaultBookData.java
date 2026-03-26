package bookstore.defaults;

import bookstore.Book;
import java.util.ArrayList;
import java.util.List;

public final class DefaultBookData {
    private DefaultBookData() {
    }

    public static List<Book> createDefaultBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 10.99, "Classic"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", 7.99, "Fiction"));
        books.add(new Book("1984", "George Orwell", "978-0451524935", 9.99, "Dystopian"));
        return books;
    }
}
