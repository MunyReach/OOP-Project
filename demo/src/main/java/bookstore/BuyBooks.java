package bookstore;

public class BuyBooks {
    public void displayBooksForSale() {
        System.out.println("Books available for sale:");
        
        if(book1.isAvailable()) {
            System.out.println("1. The Great Gatsby by F. Scott Fitzgerald - $10.99");
            buyingbook.buyBook(book1);
        }
        if(book2.isAvailable()) {
            System.out.println("2. To Kill a Mockingbird by Harper Lee - $8.99");
            buyingbook.buyBook(book2);
        }
        if(book3.isAvailable()) {
            System.out.println("3. 1984 by George Orwell - $9.99");
            buyingbook.buyBook(book3);
        }
    }
}
