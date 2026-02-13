package bookstore;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String genre;

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.genre = "General";
        
    }

    //Getters
    
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
    public String getGenre() {
        return genre;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }public void setAuthor(String author) {
        this.author = author;
    }public void setGenre(String genre) {
        this.genre = genre;
    }public void setIsbn(String isbn) {
        this.isbn = isbn;
    }public void setPrice(double price) {
        this.price = price;
    }
    
}
