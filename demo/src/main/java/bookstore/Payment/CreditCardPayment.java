package bookstore.Payment;
import java.util.Scanner;
public class CreditCardPayment implements PaymentMethod{
    private Scanner scanner;

    public CreditCardPayment(Scanner scanner) {
        this.scanner = scanner;
    }
 @Override
    public boolean pay(double amount) {
        
        System.out.println("Total amount: $" + amount);
        System.out.print("Enter 'yes' to confirm payment: ");
        String confirm = scanner.nextLine();
        return confirm.equalsIgnoreCase("yes");
    }
}
