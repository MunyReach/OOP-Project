package bookstore.MenuRelated.Buying;
import java.util.Scanner;
// new import
import bookstore.Book;
import bookstore.Payment.CreditCardPayment;
import bookstore.Payment.PaymentMethod;

public class Buyingbook {

    public void buyBook(Book book, Scanner scanner, BuyBooks buyBooks) {
        if (!book.isAvailable()) {
                System.out.println("Sorry, " + book.getTitle() + " is out of stock.");
                return;
            }

            PaymentMethod payment = new CreditCardPayment(scanner);
            boolean success = payment.pay(book.getPrice());

            if (success) {
                book.reduceQuantity(1);
                System.out.println("You successfully bought: " + book.getTitle());
                
                // Ask to buy more
                BuyMoreBook buyMore = new BuyMoreBook(scanner, buyBooks);
                buyMore.askToBuyMore();
                
            } else {
                System.out.println("Payment failed.");
            }
        }

}
