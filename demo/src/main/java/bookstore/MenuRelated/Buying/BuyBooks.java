package bookstore.MenuRelated.Buying;

//new import 
import bookstore.Book;
import bookstore.book.BookStock;

import java.util.Scanner;

public class BuyBooks {

    private BookStock bookStock;
    private Buyingbook buyer = new Buyingbook();
    private Scanner scanner;

    // Constructor receives shared book stock and scanner
    public BuyBooks(BookStock bookStock, Scanner scanner) {
        this.bookStock = bookStock;
        this.scanner = scanner;
    }

    public void displayBooksForSale() {

        System.out.println("Books available for sale:");

        if (bookStock.isEmpty()) {
            System.out.println("No books in stock.");
            return;
        }

        for (int i = 0; i < bookStock.getBooks().size(); i++) {
            System.out.print((i + 1) + ". ");
            bookStock.getBooks().get(i).displayInfo();
        }

        System.out.println("\nCommand Guide:");
        System.out.println("- Enter 1 to " + bookStock.getBooks().size() + " to buy that book");
        System.out.println("- Enter 0 to cancel and return");

        System.out.print("Enter your command: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid selection. Please enter a number.");
            scanner.nextLine();
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (choice == 0) {
            System.out.println("Purchase canceled.");
            return;
        }

        if (choice >= 1 && choice <= bookStock.getBooks().size()) {
            Book selected = bookStock.getBooks().get(choice - 1);
            buyer.buyBook(selected, scanner, this); // pass scanner and this BuyBooks
        } else {
            System.out.println("Invalid selection.");
        }

    }
}

