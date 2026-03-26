package bookstore.MenuRelated.SpecificMenu;

import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveCashier;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveManager;
import bookstore.User.Staff.User;
import bookstore.User.Staff.CashierList;
import bookstore.User.Staff.ManagerList;
import bookstore.book.bookstk;
import java.util.Scanner;

public class OwnerMenu {
    protected bookstore.MenuRelated.Menu menu;
    protected bookstk bookStock;
    protected Scanner scanner;
    protected CashierList cashierList;
    protected ManagerList managerList;
    
    public OwnerMenu(bookstk bookStock, Scanner scanner, CashierList cashierList, ManagerList managerList) {
        this.menu = new bookstore.MenuRelated.Menu();
        this.bookStock = bookStock;
        this.scanner = scanner;
        this.cashierList = cashierList;
        this.managerList = managerList;
    }

    public void handleUserMenu(User user) {
        while (true) {
            menu.DisplayMenu(user);

            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch(menuChoice) {
                case 0:
                    System.out.println("Logging out...\n");
                    return;
                case 1:
                    // Display book stock
                    AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner);
                    addRemove.displayTotalBookStock();
                    break;
                case 2:
                    // Add Cashier
                    AddRemoveCashier addCashier = new AddRemoveCashier(cashierList);
                    System.out.print("Enter cashier name: ");
                    String cashierName = scanner.nextLine();
                    System.out.print("Enter cashier email: ");
                    String cashierEmail = scanner.nextLine();
                    System.out.print("Enter cashier password: ");
                    String cashierPassword = scanner.nextLine();
                    addCashier.addCashier(cashierName, cashierEmail, cashierPassword);
                    break;
                case 3:
                    // Remove Cashier
                    AddRemoveCashier removeCashier = new AddRemoveCashier(cashierList);
                    System.out.print("Enter cashier name to remove: ");
                    String cashierNameRemove = scanner.nextLine();
                    removeCashier.removeCashier(cashierNameRemove);
                    break;
                case 4:
                    // Add Manager
                    AddRemoveManager addManager = new AddRemoveManager(managerList);
                    System.out.print("Enter manager name: ");
                    String managerName = scanner.nextLine();
                    System.out.print("Enter manager email: ");
                    String managerEmail = scanner.nextLine();
                    System.out.print("Enter manager password: ");
                    String managerPassword = scanner.nextLine();
                    addManager.addManager(managerName, managerEmail, managerPassword);
                    break;
                case 5:
                    // Remove Manager
                    AddRemoveManager removeManager = new AddRemoveManager(managerList);
                    System.out.print("Enter manager name to remove: ");
                    String managerNameRemove = scanner.nextLine();
                    removeManager.removeManager(managerNameRemove);
                    break;
                case 6:
                    // Display Cashier
                    AddRemoveCashier displayCashier = new AddRemoveCashier(cashierList);
                    displayCashier.displayCashier();
                    break;
                case 7:
                    // Display Manager
                    AddRemoveManager displayManager = new AddRemoveManager(managerList);
                    displayManager.displayManagers();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
