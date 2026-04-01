package bookstore.Receipt;

import bookstore.Book;
import java.util.List;

public class Receipt {
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;
    private double quantity;
    private double totalPrice;

    public static void generateReciept(List<Book> books, List<Integer> quantities) {
        double subTotal = 0.0;

        System.out.println("----- Receipt -----");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int qty = quantities.get(i);
            double lineTotal = book.getPrice() * qty;
            subTotal += lineTotal;

            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price per Book: $" + book.getPrice());
            System.out.println("Quantity: " + qty);
            System.out.println("Total Price per Book: $" + String.format("%.2f", lineTotal));
            System.out.println("-------------------");
        }

        System.out.println("Order Subtotal: $" + String.format("%.2f", subTotal));
        System.out.println("-------------------");

        ReceiptTxtWriter.appendOrderReceiptBlock(books, quantities);

        // Requirement Generate CSV receipt for order summary
        ReceiptCsvWriter.appendReceipt("Order Summary", "Multiple Books", subTotal, 1, subTotal);
    }

    //getters
    public String getBookAuthor() {
        return bookAuthor;
    }
    public double getBookPrice() {
        return bookPrice;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public double getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    //setters
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }public void setQuantity(double quantity) {
        this.quantity = quantity;
    }public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}