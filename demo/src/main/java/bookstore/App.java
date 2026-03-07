package bookstore;

import bookstore.MenuRelated.Buying.BuyBooks;
import java.util.Scanner;
//simplify app and move scanner 
public class App 
{
    
    public static void main( String[] args )
    {
       Scanner scanner = new Scanner(System.in);  // only one scanner

        System.out.println("====== Welcome to Bookstore ======");
        
        BuyBooks buyBooks = new BuyBooks(scanner); // pass scanner to BuyBooks
        buyBooks.displayBooksForSale();

        scanner.close();  // close only at the very end

//delete old if condition because repetitive input in scanner.nextline

    }
}

