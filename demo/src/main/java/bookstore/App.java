package bookstore;

import bookstore.Books.BookInfoHolder;
import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.Buying.BuyBooks;

java.util.Scanner;
public class App 
{
    
    public static void main( String[] args )
    {   
        


        //Print menu
        Menu menu1 = new Menu();
        menu1.DisplayMenu();
        Scanner scanner = new Scanner(System.in);



        if(scanner.nextLine().equals("1")){
            System.out.println("You have selected to buy books.");
            BuyBooks buyBooks = new BuyBooks();
            buyBooks.displayBooksForSale();
        }
        else if(scanner.nextLine().equals("2"))
        {
            System.out.println("You have selected to borrow books.");
        }
        else if(scanner.nextLine().equals("3"))
        {
            System.out.println("You have selected to return books.");
        }
        else
        {
            System.out.println("Invalid selection. Please choose a valid option from the menu.");
        }

        BookInfoHolder bookInfoHolder = new BookInfoHolder();
        bookInfoHolder.displayBooks();

    }
    
}

