package bookstore;

import java.util.Date;

public class Order {
    private final Customer customer;;
    private final Book book;
    private final Date orderDate;
    private final double totalAmount;

    public Order(Customer customer, Book book) {
        this.customer = customer;
        this.book = book;
        this.orderDate = new Date();
        this.totalAmount = book.getPrice();
    }


    public void processOrder(PaymentMethod payment) {
        System.out.println("Processing order from: " + book.getTitle());
        System.out.println("Processing order for customer: " + customer.getName());
        boolean success = payment.pay(totalAmount);
        if (success) {
            System.out.println("Order completed successfully on: " + orderDate);
        } else {
            System.out.println("Order failed.");
        }
    }
    public Customer getCustomer() { return customer; }
    public Book getBook() { return book; }
    public Date getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }

}
