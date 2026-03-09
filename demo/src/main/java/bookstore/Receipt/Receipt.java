package bookstore.Receipt;

public class Receipt {
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;
    private double quantity;
    private double totalPrice;

    public static void generateReciept(String bookTitle, String bookAuthor, double bookPrice, double quantity) {
        double totalPrice = bookPrice * quantity;
        
        System.out.println("----- Receipt -----");
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + bookAuthor);
        System.out.println("Price per Book: $" + bookPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("-------------------");
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