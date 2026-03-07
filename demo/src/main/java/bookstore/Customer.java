package bookstore;

public class Customer extends User{
    public Customer(String name, String email) {
        super(name, email);
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public void purchaseBook(Book book, PaymentMethod payment) {
        boolean success = payment.pay(book.getPrice());

        if (success) {
            System.out.println(name + " purchased: " + book.getTitle());
        } else {
            System.out.println("Payment failed!");
        }
    }
}
