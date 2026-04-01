package bookstore.Receipt;

import bookstore.Book;
import java.util.List;

public class Receipt {
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;
    private double quantity;
    private double totalPrice;

    private static final double TAX_RATE = 0.07;
    private static final java.time.format.DateTimeFormatter DATE_TIME_FORMATTER = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void generateReciept(List<Book> books, List<Integer> quantities, String paymentMethod, String customerPhone, String customerAddress, String cashierName) {
        double subTotal = 0.0;

        System.out.println("OOP Bookstore");
        System.out.println("Date, Time: " + java.time.LocalDateTime.now().format(DATE_TIME_FORMATTER));
        System.out.println("Payment method : " + paymentMethod);
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Customer Phone Number: " + customerPhone);
        System.out.println("Address: " + customerAddress);
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-25s %-8s %-20s %-15s%n", "Book Name", "Amount", "(price per unit)", "Total per book");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int qty = quantities.get(i);
            double lineTotal = book.getPrice() * qty;
            subTotal += lineTotal;

            System.out.printf("%-25s %-8d $%-19.2f $%-15.2f%n",
                    book.getTitle(), qty, book.getPrice(), lineTotal);
        }

        double tax = subTotal * TAX_RATE;
        double total = subTotal + tax;

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Tax (always 7%): $" + String.format("%.2f", tax));
        System.out.println("Total : $" + String.format("%.2f", total));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Cashier Name: " + cashierName);
        System.out.println();
        System.out.println("Thank you for your purchase. Please come again next time. With love, OOP Bookstore:3");
        System.out.println("-----------------------------------------------------------------------------------");

        ReceiptTxtWriter.appendOrderReceiptBlock(books, quantities, paymentMethod, customerPhone, customerAddress, cashierName);

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