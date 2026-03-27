package bookstore;

import java.util.Scanner;

import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.SpecificMenu.CashierMenu;
import bookstore.MenuRelated.SpecificMenu.ManagerMenu;
import bookstore.MenuRelated.SpecificMenu.OwnerMenu;
import bookstore.User.Staff.CashierList;
import bookstore.User.Staff.ManagerList;
import bookstore.User.Staff.User;
import bookstore.auth.CashierLoginHandler;
import bookstore.auth.LoginHandler;
import bookstore.auth.ManagerLoginHandler;
import bookstore.auth.OwnerLoginHandler;
import bookstore.defaults.DefaultBookData;
import bookstore.defaults.DefaultManagerData;
import bookstore.defaults.DefaultStaffData;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        
        // Initialize cashier and manager lists
        CashierList cashierList = new CashierList(DefaultStaffData.createDefaultStaffMembers());
        ManagerList managerList = new ManagerList(DefaultManagerData.createDefaultManagers());
        
        LoginHandler ownerLoginHandler = new OwnerLoginHandler();
        LoginHandler managerLoginHandler = new ManagerLoginHandler(managerList);
        LoginHandler cashierLoginHandler = new CashierLoginHandler(cashierList);
        bookstore.book.bookstk bookStock = new bookstore.book.bookstk(DefaultBookData.createDefaultBooks());
        
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
                    user = cashierLoginHandler.login(scanner);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            // Show role-based menu if login successful
            if (user != null) {
                System.out.println();

                if (user.getRole().equals("Owner")) {
                    OwnerMenu ownerMenu = new OwnerMenu(bookStock, scanner, cashierList, managerList);
                    ownerMenu.handleUserMenu(user);
                } else if (user.getRole().equals("Manager")) {
                    ManagerMenu managerMenu = new ManagerMenu(bookStock, scanner, cashierList, managerList);
                    managerMenu.handleUserMenu(user);
                } else if (user.getRole().equals("Cashier")) {
                    CashierMenu cashierMenu = new CashierMenu(bookStock, scanner);
                    cashierMenu.handleUserMenu(user);
                }
            }
        }
    }
}
