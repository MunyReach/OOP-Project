package bookstore.User.Staff.AddRemoveDisplay;

import bookstore.Book;
import bookstore.book.bookstk;

import java.util.Scanner;

public class AddRemoveBook {
    private bookstk bookStock;
    private Scanner scanner;

    public AddRemoveBook(bookstk bookStock, Scanner scanner) {
        this.bookStock = bookStock;
        this.scanner = scanner;
    }

    public void addBook(Book book) {
        if (book != null) {
            bookStock.addBook(book);
        }
    }

    public void addBookFromInput() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Book newBook = new Book(title, author, isbn, price, category);
        addBook(newBook);
    }

    public void removeBook(Book book) {
        if (book != null) {
            bookStock.removeBook(book);
        }
    }

    public void removeBookFromInput() {
        System.out.println("\n--- Remove Book ---");
        System.out.println("1. Remove by ISBN");
        System.out.println("2. Remove by Title");
        System.out.print("Enter choice: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid choice! Please enter a number.");
            scanner.nextLine();
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            bookStock.removeBookByISBN(isbn);
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            bookStock.removeBookByTitle(title);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public void displayBookStock() {
        bookStock.displayAllBooks();
    }

    public void displayTotalBookStock() {
        int totalQuantity = 0;
        
        for (Book book : bookStock.getBooks()) {
            totalQuantity += book.getQuantity();
        }


        bookStock.displayAllBooks();
        System.out.println("Total books in stock: " + totalQuantity);
        
    }
    
}
