package bookstore;

/**
 * Unit test for simple App.
 */

public class App {
    public static void main(String[] args) {

        System.out.println("=== Starting Standard Purchase Test ===");
        Book javaBook = new Book("OOP in Java", "Vitou Porleak", "123-456", 29.99);
        Customer vitou = new Customer("Vitou Porleak", "vitou@email.com");
        

        PaymentMethod myCard = new CardPayment("1111-2222-3333-444");
        
        Order normalOrder = new Order(vitou, javaBook);
        normalOrder.processOrder(myCard);

        System.out.println("\n=== Starting Negative Price Test ===");
        // --- TEST 2: Encapsulation (Bad Data Check) ---

        javaBook.setPrice(-50.0); 
        System.out.println("Book price is now: $" + javaBook.getPrice()); 

        System.out.println("\n=== Starting Cash Payment Test ===");
        // --- TEST 3: Polymorphism (Swapping Payment Types) ---
        PaymentMethod cash = new CashPayment();
        normalOrder.processOrder(cash);
    }
}

    
