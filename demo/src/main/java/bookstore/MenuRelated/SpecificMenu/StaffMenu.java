package bookstore.MenuRelated.SpecificMenu;

import bookstore.MenuRelated.Menu;
import bookstore.MenuRelated.Buying.BuyBooks;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;

import bookstore.book.bookstk;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class StaffMenu {
    protected Menu menu;
    protected bookstk bookStock;
    protected Scanner scanner;

    public StaffMenu(bookstk bookStock, Scanner scanner) {
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

            AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner);

            switch(menuChoice) {
                case 0:
                    return;
                case 1:
                    BuyBooks buyBooks = new BuyBooks(bookStock, scanner);
                    buyBooks.displayBooksForSale();
                    break;
                case 2:
                    addRemove.addBookFromInput();
                    break;
                case 3:
                    addRemove.removeBookFromInput();
                    break;
                case 4:
                    addRemove.displayBookStock();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}