package bookstore;

import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.Buying.BuyBooks;
import bookstore.MenuRelated.SpecificMenu.OwnerMenu;
import bookstore.MenuRelated.SpecificMenu.ManagerMenu;
import bookstore.MenuRelated.SpecificMenu.StaffMenu;
import bookstore.auth.LoginHandler;
import bookstore.auth.ManagerLoginHandler;
import bookstore.auth.OwnerLoginHandler;
import bookstore.auth.StaffLoginHandler;
import bookstore.book.BookStock;
import bookstore.defaults.DefaultBookData;
import bookstore.defaults.DefaultManagerData;
import bookstore.defaults.DefaultStaffData;
import bookstore.User.Staff.User;
import bookstore.User.Staff.StaffList;
import bookstore.User.Staff.ManagerList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        
        // Initialize staff and manager lists
        StaffList staffList = new StaffList(DefaultStaffData.createDefaultStaffMembers());
        ManagerList managerList = new ManagerList(DefaultManagerData.createDefaultManagers());
        
        LoginHandler ownerLoginHandler = new OwnerLoginHandler();
        LoginHandler managerLoginHandler = new ManagerLoginHandler(managerList);
        LoginHandler staffLoginHandler = new StaffLoginHandler(staffList);
        BookStock bookStock = new BookStock(DefaultBookData.createDefaultBooks());
        
        System.out.println("====== Welcome to Bookstore ======\n");

        while (true) {
            // Show login menu
            menu.DisplayBeforeLogin();
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            User user = null;

            // Handle login choice
            switch(choice) {
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
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
                    BuyBooks buyBooks = new BuyBooks(bookStock, scanner);
                    buyBooks.displayBooksForSale();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            // Show role-based menu if login successful
            if (user != null) {
                System.out.println();

                if (user.getRole().equals("Owner")) {
                    OwnerMenu ownerMenu = new OwnerMenu(bookStock, scanner, staffList, managerList);
                    ownerMenu.handleUserMenu(user);
                } else if (user.getRole().equals("Manager")) {
                    ManagerMenu managerMenu = new ManagerMenu(bookStock, scanner, staffList);
                    managerMenu.handleUserMenu(user);
                } else if (user.getRole().equals("Staff")) {
                    StaffMenu staffMenu = new StaffMenu(bookStock, scanner);
                    staffMenu.handleUserMenu(user);
                }
            }
        }
    }
}

