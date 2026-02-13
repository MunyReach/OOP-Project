package bookstore.MenuRelated.Buying;
util.Scanner;
public class Buyingbook {
    public void buyBook(Book book) {
        if(book.isAvailable()) {
            System.out.println("You have bought: " + book.getTitle() + " by " + book.getAuthor());
            // Here you can add code to update inventory, process payment, etc.
            book.setQuantity(book.getQuantity() - 1);
            BuyMoreBooks buyMoreBooks = new BuyMoreBooks();
            buyMoreBooks.askToBuyMore();
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is currently unavailable.");
        }
    }

}
