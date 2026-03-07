package bookstore.MenuRelated.Buying;
import java.util.Scanner;
import bookstore.App;

public class BuyMoreBook {

    
        private Scanner scanner;
        private BuyBooks buyBooks;

    // Constructor receives the same scanner and BuyBooks instance
        public BuyMoreBook(Scanner scanner, BuyBooks buyBooks) {
        this.scanner = scanner;
        this.buyBooks = buyBooks;
    }
        
        public void askToBuyMore() {

        System.out.println("Do you want to buy more books? (y/n)");
        String response = scanner.nextLine();
        
        if (response.equalsIgnoreCase("y")) {
            buyBooks.displayBooksForSale(); // reuse existing BuyBooks
        } else {
            System.out.println("Thank you for shopping with us!");
        }
    }
}
