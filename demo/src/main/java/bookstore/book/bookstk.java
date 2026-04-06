package bookstore.book;

import bookstore.Book;
import bookstore.defaults.DefaultBookData;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class bookstk {
    private List<Book> books;
    private static final Path BOOKS_FILE = resolveBooksFilePath();

    public bookstk() {
        this.books = loadBooksFromFile();
        if (this.books.isEmpty()) {
            // Load defaults if no saved data
            this.books = DefaultBookData.createDefaultBooks();
            saveBooksToFile();
        }
    }

    public bookstk(List<Book> books) {
        this.books = new ArrayList<>(books);
        saveBooksToFile();
    }

    // Add a new book to stock
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("✓ Book added: " + book.getTitle() + " by " + book.getAuthor());
            displayAllBooks();
            saveBooksToFile();
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
                saveBooksToFile();
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
                saveBooksToFile();
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
            saveBooksToFile();
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
            books.get(i).displayInfo();
        }
        System.out.println("\nTotal titles: " + books.size());
    }

    // Find book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
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

    // Save books to file
    public void saveBooksToFile() {
        try {
            Files.createDirectories(BOOKS_FILE.getParent());
            List<String> lines = new ArrayList<>();
            for (Book book : books) {
                lines.add(book.getBookId() + "," + book.getTitle() + "," + book.getAuthor() + "," + 
                         book.getIsbn() + "," + book.getPrice() + "," + book.getCategory() + "," + book.getQuantity());
            }
            Files.write(BOOKS_FILE, lines);
        } catch (IOException e) {
            System.out.println("Could not save books to file: " + e.getMessage());
        }
    }

    // Load books from file
    private List<Book> loadBooksFromFile() {
        List<Book> loadedBooks = new ArrayList<>();
        int maxId = 0;
        try {
            if (Files.exists(BOOKS_FILE)) {
                List<String> lines = Files.readAllLines(BOOKS_FILE);
                for (String line : lines) {
                    String[] parts = line.split(",");
                    if (parts.length == 7) {
                        int bookId = Integer.parseInt(parts[0]);
                        maxId = Math.max(maxId, bookId);
                        String title = parts[1];
                        String author = parts[2];
                        String isbn = parts[3];
                        double price = Double.parseDouble(parts[4]);
                        String category = parts[5];
                        int quantity = Integer.parseInt(parts[6]);
                        
                        Book book = new Book(title, author, isbn, price, category, quantity);
                        book.setBookId(bookId);
                        loadedBooks.add(book);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load books from file: " + e.getMessage());
        }
        // Update nextBookId
        Book.setNextBookId(maxId + 1);
        return loadedBooks;
    }

    // Resolve books file path
    private static Path resolveBooksFilePath() {
        return Paths.get("demo", "src", "Report", "books.txt");
    }
}