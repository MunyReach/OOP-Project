package bookstore;

import bookstore.MenuRelated.Buying.BuyBooks;
import java.util.Scanner;

public class App 
{
    
    public static void main( String[] args )
    {
    Scanner scanner = new Scanner(System.in);

        System.out.println("====== Welcome to Bookstore ======");
        
        BuyBooks buyBooks = new BuyBooks(scanner);
        buyBooks.displayBooksForSale();

        scanner.close();

    }
}

