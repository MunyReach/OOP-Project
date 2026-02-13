package bookstore.Books;

public class Booksettings {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String genre;
    private int quantity;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.genre = "Unknown"; // Default genre
        this.quantity = 1; // Default quantity
        this.isAvailable = true; // Default availability
        
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

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: $" + price);
        System.out.println("Genre: " + genre);
    }
    if(this.quantity > 0) {
        this.isAvailable = true;
    } else {
        this.isAvailable = false;
    }
    
}
