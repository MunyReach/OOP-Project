package bookstore;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String category;
    private int quantity;

    public Book(String title, String author, String isbn, double price, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
        this.quantity = 5; // default quantity
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    //Change by Liya; adding displayinfo here and quatity

    public boolean isAvailable() { return quantity > 0; }

    public void reduceQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) quantity = 0;
    }

        public void displayInfo() {
        System.out.println(title + " by " + author + " - $" + price + " (" + quantity + " left)");
    }
}

