package bookstore;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ){
        Book myBook = new Book("OOP Java Programming", "Vitou Porleak", "123-456", 30.0);
        Customer vitou = new Customer("Vitou Porleak", "vitou@email.com");
        PaymentMethod payByCash = new CashPayment();
        PaymentMethod payByCard = new CardPayment("1111-2222-3333-4444");
        System.out.println("--- Cash Payment ---");
        vitou.purchaseBook(myBook, payByCash);
        System.out.println("\n--- Card Payment ---");
        vitou.purchaseBook(myBook, payByCard);

    }
}

