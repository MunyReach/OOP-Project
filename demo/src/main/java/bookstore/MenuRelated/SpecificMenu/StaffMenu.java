package bookstore.MenuRelated.SpecificMenu;

import bookstore.MenuRelated.Menu;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;

import bookstore.book.BookStock;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class StaffMenu {
    protected Menu menu;
    protected BookStock bookStock;
    protected Scanner scanner;

    public StaffMenu(BookStock bookStock, Scanner scanner) {
        this.menu = new Menu();
        this.bookStock = bookStock;
        this.scanner = scanner;
    }

    public void handleUserMenu(User user) {
        menu.DisplayMenu(user);
        
        System.out.print("Enter your choice: ");
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        
        AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner);
        
        switch(menuChoice) {
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