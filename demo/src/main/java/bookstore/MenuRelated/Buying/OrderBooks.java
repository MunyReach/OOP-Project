package bookstore.MenuRelated.Buying;

import bookstore.Book;
import bookstore.book.bookstk;
import bookstore.Receipt.Receipt;
import bookstore.User.Staff.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBooks {

    private bookstk bookStock;
    private Scanner scanner;
    private User currentUser;

    // Constructor receives shared book stock and scanner
    public OrderBooks(bookstk bookStock, Scanner scanner) {
        this.bookStock = bookStock;
        this.scanner = scanner;
    }

    // Constructor also binds the currently logged-in user for permission checks
    public OrderBooks(bookstk bookStock, Scanner scanner, User currentUser) {
        this.bookStock = bookStock;
        this.scanner = scanner;
        this.currentUser = currentUser;
    }

    // Main order flow: validates ID and quantity, processes payment, and updates stock
    public void displayBooksForOrder() {

        if (currentUser == null || !currentUser.canMakeOrder()) {
            System.out.println("Only cashier can make order.");
            return;
        }

        System.out.println("Books available for order:");

        if (bookStock.isEmpty()) {
            System.out.println("No books in stock.");
            return;
        }

        for (Book book : bookStock.getBooks()) {
            book.displayInfo();
        }

        List<Book> orderedBooks = new ArrayList<>();
        List<Integer> orderedQuantities = new ArrayList<>();

        while (true) {
            int idAttempts = 5;
            Book selected = null;

            while (idAttempts > 0) {
                System.out.println();
                System.out.println("Enter book ID to order");
                System.out.println("Enter 000 to cancel and return to MENU");
                System.out.print("Enter Book ID to order: ");
                String bookIdInput = scanner.nextLine().trim();

                if ("000".equals(bookIdInput)) {
                    System.out.println("Order canceled.");
                    return;
                }

                if (bookIdInput.length() != 3 || !isAllDigits(bookIdInput)) {
                    idAttempts--;
                    System.out.println("Invalid ID. Attempts left: " + idAttempts);
                    if (idAttempts == 0) {
                        System.out.println("Too many invalid ID attempts. Returning to MENU.");
                        return;
                    }
                    continue;
                }

                int bookId = Integer.parseInt(bookIdInput);
                if (bookId < 1 || bookId > bookStock.getBooks().size()) {
                    idAttempts--;
                    System.out.println("Invalid ID. Attempts left: " + idAttempts);
                    if (idAttempts == 0) {
                        System.out.println("Too many invalid ID attempts. Returning to MENU.");
                        return;
                    }
                    continue;
                }

                selected = bookStock.findBookById(bookId);
                if (selected == null) {
                    idAttempts--;
                    System.out.println("Invalid ID. Attempts left: " + idAttempts);
                    if (idAttempts == 0) {
                        System.out.println("Too many invalid ID attempts. Returning to MENU.");
                        return;
                    }
                    continue;
                }

                break;
            }

            int quantityAttempts = 5;
            int quantity = -1;
            while (quantityAttempts > 0) {
                quantity = readValidQuantity();
                if (quantity != -1) {
                    break;
                }
                quantityAttempts--;
                System.out.println("Invalid amount. Attempts left: " + quantityAttempts);
                if (quantityAttempts == 0) {
                    System.out.println("Too many invalid quantity attempts. Returning to MENU.");
                    return;
                }
            }

            int existingIndex = orderedBooks.indexOf(selected);
            int alreadyOrdered = existingIndex >= 0 ? orderedQuantities.get(existingIndex) : 0;
            int newTotalForBook = alreadyOrdered + quantity;

            if (newTotalForBook > 5) {
                System.out.println("Invalid amount. Maximum per book is 5.");
                continue;
            }

            if (newTotalForBook > selected.getQuantity()) {
                System.out.println("Invalid amount. Not enough stock.");
                continue;
            }

            if (existingIndex >= 0) {
                orderedQuantities.set(existingIndex, newTotalForBook);
            } else {
                orderedBooks.add(selected);
                orderedQuantities.add(quantity);
            }

            if (!askToOrderMore()) {
                break;
            }
        }

        double totalAmount = 0.0;
        for (int i = 0; i < orderedBooks.size(); i++) {
            totalAmount += orderedBooks.get(i).getPrice() * orderedQuantities.get(i);
        }

        System.out.println("Total order amount: $" + totalAmount);

        System.out.print("Enter cashier password to confirm payment: ");
        String cashierPassword = scanner.nextLine().trim();
        if (!currentUser.isPasswordCorrect(cashierPassword)) {
            System.out.println("Incorrect password. Payment cancelled.");
            return;
        }

        for (int i = 0; i < orderedBooks.size(); i++) {
            Book book = orderedBooks.get(i);
            int quantity = orderedQuantities.get(i);
            book.reduceQuantity(quantity);
            Receipt.generateReciept(book.getTitle(), book.getAuthor(), book.getPrice(), quantity);
        }

        System.out.println("Thank you for shopping with us!");
    }

    // Reads and validates quantity input (must be numeric and between 1 and 5)
    private int readValidQuantity() {
        System.out.print("-> Enter Quantity of the Books: ");
        String quantityInput = scanner.nextLine().trim();

        if (quantityInput.isEmpty() || !isAllDigits(quantityInput)) {
            System.out.println("Invalid amount.");
            return -1;
        }

        int quantity = Integer.parseInt(quantityInput);
        if (quantity <= 0 || quantity > 5) {
            System.out.println("Invalid amount.");
            return -1;
        }

        return quantity;
    }

    // Asks whether the user wants to continue ordering more books
    private boolean askToOrderMore() {
        while (true) {
            System.out.print("Do you want to order more books? (Y/N): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("y")) {
                return true;
            }
            if (response.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Invalid choice.");
        }
    }

    // Utility checker to ensure an input string contains only digits
    private boolean isAllDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
