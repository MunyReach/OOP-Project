package bookstore.MenuRelated.SpecificMenu;

import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;
import bookstore.User.Staff.User;
import bookstore.User.Staff.CashierList;
import bookstore.book.bookstk;


import java.util.Scanner;

public class ManagerMenu {
    protected bookstore.MenuRelated.Menu menu;
    protected bookstk bookStock;
    protected Scanner scanner;
    protected CashierList cashierList;
    
    public ManagerMenu(bookstk bookStock, Scanner scanner, CashierList cashierList) {
        this.menu = new bookstore.MenuRelated.Menu();
        this.bookStock = bookStock;
        this.scanner = scanner;
        this.cashierList = cashierList;
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

            AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner);

            switch(menuChoice) {
                case 0:
                    System.out.println("Logging out...\n");
                    return;
                case 1:
                    addRemove.displayBookStock();
                    break;
                case 2:
                    displaySaleInfo();
                    break;
                case 3:
                    addRemove.addBookFromInput();
                    break;
                case 4:
                    addRemove.removeBookFromInput();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    protected void displaySaleInfo() {
        System.out.println("\n===== Sales Information =====");
        System.out.println("Sale Report Feature Coming Soon");
        System.out.println("===============================\n");
    }
}
