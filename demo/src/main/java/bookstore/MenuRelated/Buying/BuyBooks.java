package bookstore.MenuRelated.Buying;

//new import 
import bookstore.Book;
import bookstore.book.BookInfoHolder;

import java.util.Scanner;

//and simplfiy this because book1,2,3 was undefined and delete "buyingbook" object  and isAvailable() doesn't exist
public class BuyBooks {
    
    private BookInfoHolder holder = new BookInfoHolder();
    private Buyingbook buyer = new Buyingbook();
    private Scanner scanner;

    // Constructor receives Scanner from App
    public BuyBooks(Scanner scanner) {
        this.scanner = scanner;
    }
    public void displayBooksForSale() {

        System.out.println("Books available for sale:");

        holder.displayBooks();

        System.out.print("Enter the number of the book you want to buy: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (choice >= 1 && choice <= holder.getBooks().size()) {
            Book selected = holder.getBooks().get(choice - 1);
            buyer.buyBook(selected, scanner, this); // pass scanner and this BuyBooks
        } else {
            System.out.println("Invalid selection.");
        }

    }
}

