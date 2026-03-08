package bookstore.book;

import bookstore.Book;
import java.util.List;
import java.util.ArrayList;

public class BookStock {
    private List<Book> books;

    public BookStock() {
        this.books = new ArrayList<>();
    }

    public BookStock(List<Book> books) {
        this.books = books;
    }

    // Add a new book to stock
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("✓ Book added: " + book.getTitle() + " by " + book.getAuthor());
            displayAllBooks();
        } else {
            System.out.println("✗ Cannot add null book!");
        }
    }

    // Remove book by ISBN
    public boolean removeBookByISBN(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                Book removed = books.remove(i);
                System.out.println("✓ Book removed: " + removed.getTitle());
                return true;
            }
        }
        System.out.println("✗ Book with ISBN " + isbn + " not found!");
        return false;
    }

    // Remove book by title
    public boolean removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book removed = books.remove(i);
                System.out.println("✓ Book removed: " + removed.getTitle());
                return true;
            }
        }
        System.out.println("✗ Book with title '" + title + "' not found!");
        return false;
    }

    // Remove specific book object
    public boolean removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("✓ Book removed: " + book.getTitle());
            return true;
        }
        System.out.println("✗ Book not found in stock!");
        return false;
    }

    // Display all books in stock
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in stock.");
            return;
        }
        
        System.out.println("\n===== Book Stock =====");
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i + 1) + ". ");
            books.get(i).displayInfo();
        }
        System.out.println("Total books: " + books.size());
    }

    // Find book by ISBN
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Find book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Get all books
    public List<Book> getBooks() {
        return books;
    }

    // Get total number of books
    public int getTotalBooks() {
        return books.size();
    }

    // Check if stock is empty
    public boolean isEmpty() {
        return books.isEmpty();
    }
}