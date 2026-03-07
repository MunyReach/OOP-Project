package bookstore;

import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.Buying.BuyBooks;
import bookstore.auth.LoginHandler;
import bookstore.auth.ManagerLoginHandler;
import bookstore.auth.OwnerLoginHandler;
import bookstore.auth.StaffLoginHandler;
import bookstore.book.BookStock;
import bookstore.menu.MenuHandler;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        LoginHandler ownerLoginHandler = new OwnerLoginHandler();
        LoginHandler managerLoginHandler = new ManagerLoginHandler();
        LoginHandler staffLoginHandler = new StaffLoginHandler();
        BookStock bookStock = new BookStock();
        MenuHandler menuHandler = new MenuHandler(bookStock, scanner);
        
        System.out.println("====== Welcome to Bookstore ======\n");
        
        // Show login menu
        menu.DisplayBeforeLogin();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        User user = null;
        
        // Handle login choice
        switch(choice) {
            case 1:
                user = ownerLoginHandler.login(scanner);
                break;
            case 2:
                user = managerLoginHandler.login(scanner);
                break;
            case 3:
                user = staffLoginHandler.login(scanner);
                break;
            case 4:
                // Buy books as guest
                BuyBooks buyBooks = new BuyBooks(scanner);
                buyBooks.displayBooksForSale();
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }
        
        // Show role-based menu if login successful
        if (user != null) {
            System.out.println();
            menuHandler.handleUserMenu(user);
            if(user.getRole().equals("Staff")){
                
            }
        }
        
        scanner.close();
    }
}

