package bookstore.MenuRelated.SpecificMenu;

import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveStaff;
import bookstore.User.Staff.User;
import bookstore.User.Staff.StaffList;
import bookstore.book.BookStock;
import java.util.Scanner;

public class ManagerMenu extends StaffMenu {
    protected StaffList staffList;
    
    public ManagerMenu(BookStock bookStock, Scanner scanner, StaffList staffList) {
        super(bookStock, scanner);
        this.staffList = staffList;
    }

    @Override
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
            case 5:

                AddRemoveStaff addStaff = new AddRemoveStaff(staffList);
                System.out.print("Enter staff name: ");
                String staffName = scanner.nextLine();
                System.out.print("Enter staff email: ");
                String staffEmail = scanner.nextLine();
                System.out.print("Enter staff password: ");
                String staffPassword = scanner.nextLine();
                addStaff.addStaff(staffName, staffEmail, staffPassword);
                break;

            case 6:

                AddRemoveStaff removeStaff = new AddRemoveStaff(staffList);
                System.out.print("Enter staff name to remove: ");
                String nameToRemove = scanner.nextLine();
                removeStaff.removeStaff(nameToRemove);
                break;
            case 7:
                addRemove.displayBookStock();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
