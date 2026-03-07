package bookstore;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String category;

    public Book(String title, String author, String isbn, double price, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
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
    
}
