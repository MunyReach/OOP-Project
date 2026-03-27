package bookstore.MenuRelated.SpecificMenu;

import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.Buying.OrderBooks;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;

import bookstore.book.bookstk;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class CashierMenu {
    protected Menu menu;
    protected bookstk bookStock;
    protected Scanner scanner;

    public CashierMenu(bookstk bookStock, Scanner scanner) {
        this.menu = new Menu();
        this.bookStock = bookStock;
        this.scanner = scanner;
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

            // Note: Cashier uses null for managerList as they don't remove books
            AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner, null);

            switch(menuChoice) {
                case 0:
                    System.out.println("Logging out...\n");
                    return;
                case 1:
                    OrderBooks orderBooks = new OrderBooks(bookStock, scanner, user);
                    orderBooks.displayBooksForOrder();
                    break;
                case 2:
                    addRemove.displayBookStock();
                    break;
                case 3:
                    displaySaleInfo();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void displaySaleInfo() {
        System.out.println("\n===== Sales Information =====");
        System.out.println("Sale Report Feature Coming Soon");
        System.out.println("===============================\n");
    }
}
