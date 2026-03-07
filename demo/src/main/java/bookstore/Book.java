package bookstore;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private double price;

    public Book(String title, String author, String isbn, double price) {
        this.title = (title == null || title.isEmpty()) ? "Unknown Title" : title;
        this.author = (author == null || author.isEmpty()) ? "Unknown Author" : author;
        this.isbn = (isbn == null || isbn.length() < 5) ? "000-000" : isbn;
        setPrice(price);
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public String getIsbn() { return isbn; }

    public double getPrice() { return price; }
    
    public final void setPrice(double price){
        if (price >= 0) {
            this.price = price;
        }else{
            System.out.println("Price cannot be negative! ");
        }
    }
}

