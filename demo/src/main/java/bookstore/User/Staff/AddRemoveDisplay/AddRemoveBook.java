package bookstore.User.Staff.AddRemoveDisplay;

import bookstore.Book;
import bookstore.book.bookstk;
import bookstore.User.Staff.Manager;
import bookstore.User.Staff.ManagerList;

import java.util.Scanner;

public class AddRemoveBook {
    private bookstk bookStock;
    private Scanner scanner;
    private ManagerList managerList;

    public AddRemoveBook(bookstk bookStock, Scanner scanner, ManagerList managerList) {
        this.bookStock = bookStock;
        this.scanner = scanner;
        this.managerList = managerList;
    }

    public void addBook(Book book) {
        if (book != null) {
            bookStock.addBook(book);
        }
    }

    public void addBookFromInput() {
        System.out.println("\n--- Add New Book ---");
        String title;
        while (true) {
            System.out.print("Enter book title: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Title cannot be empty. Please try again.");
                continue;
            }
            title = toTitleCase(input);
            break;
        }

        String author;
        while (true) {
            System.out.print("Enter author name: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Author name cannot be empty. Please try again.");
                continue;
            }
            author = toTitleCase(input);
            break;
        }

        String isbn;
        while (true) {
            System.out.print("Enter ISBN: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.isEmpty()) {
                System.out.println("ISBN cannot be empty. Please try again.");
                continue;
            }
            boolean hasLetter = input.matches(".*[A-Z].*");
            boolean hasDigit = input.matches(".*\\d.*");
            boolean validCharacters = input.matches("[A-Z0-9-]+");

            if (!validCharacters || !hasLetter || !hasDigit) {
                System.out.println("ISBN must contain both letters and numbers (letters will be uppercase).");
                System.out.println("Allowed characters: A-Z, 0-9, and '-'. Please try again.");
                continue;
            }

            isbn = input;
            break;
        }

        double price;
        while (true) {
            System.out.print("Enter price: ");
            String input = scanner.nextLine().trim();
            try {
                price = Double.parseDouble(input);
                if (price <= 0) {
                    System.out.println("Price must be above 0. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
            }
        }

        String category;
        while (true) {
            System.out.print("Enter category: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Category cannot be empty. Please try again.");
                continue;
            }
            if (!input.matches("[A-Za-z ]+")) {
                System.out.println("Category cannot contain numbers or symbols. Please use letters only.");
                continue;
            }
            category = toTitleCase(input);
            break;
        }

        Book newBook = new Book(title, author, isbn, price, category);
        addBook(newBook);
    }

    // Converts each word to title case (first letter uppercase, remaining letters lowercase).
    private String toTitleCase(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        String result = "";

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            result += Character.toUpperCase(word.charAt(0));
            if (word.length() > 1) {
                result += word.substring(1);
            }
            result += " ";
        }

        return result.trim();
    }

    public void removeBook(Book book) {
        if (book != null) {
            bookStock.removeBook(book);
        }
    }

    public void removeBookFromInput() {
        System.out.println("\n--- Remove Book ---");
        int attempts = 5;

        while (attempts > 0) {
            System.out.println("Attempts remaining: " + attempts);

            // Step 1: Get Title
            System.out.print("Enter book title to remove: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Title cannot be empty. Please try again.");
                attempts--;
                continue;
            }
            title = toTitleCase(title);

            // Step 2: Get Book ID
            System.out.print("Enter book ID to confirm: ");
            String bookId = scanner.nextLine().trim();
            if (bookId.isEmpty()) {
                System.out.println("Book ID cannot be empty. Please try again.");
                attempts--;
                continue;
            }

            // Step 3: Verify manager password
            System.out.print("Enter manager password to authorize removal: ");
            String password = scanner.nextLine();
            if (!verifyManagerPassword(password)) {
                System.out.println("Invalid password! Authorization denied.");
                attempts--;
                if (attempts == 0) {
                    System.out.println("No attempts remaining. Exiting to menu.");
                    return;
                }
                continue;
            }

            // Step 4: Find and remove book matching the title
            boolean found = false;
            for (Book book : bookStock.getBooks()) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    bookStock.removeBook(book);
                    System.out.println("Book '" + title + "' (ID: " + bookId + ") removed successfully!");
                    found = true;
                    return;
                }
            }

            // If not found, lose an attempt
            if (!found) {
                System.out.println("No book found with title '" + title + "'.");
                attempts--;
                if (attempts == 0) {
                    System.out.println("No attempts remaining. Exiting to menu.");
                    return;
                }
            }
        }
    }

    // Helper method to verify manager password by searching all managers
    private boolean verifyManagerPassword(String password) {
        if (managerList == null) {
            return false;
        }
        for (Manager manager : managerList.getManagers()) {
            if (manager != null && manager.isPasswordCorrect(password)) {
                return manager.isPasswordCorrect(password);
            }
        }
        return false;
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
