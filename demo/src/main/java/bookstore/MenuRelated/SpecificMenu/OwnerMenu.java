package bookstore.MenuRelated.SpecificMenu;

import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveStaff;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveManager;
import bookstore.User.Staff.User;
import bookstore.User.Staff.StaffList;
import bookstore.User.Staff.ManagerList;
import bookstore.book.bookstk;
import java.util.Scanner;

public class OwnerMenu extends ManagerMenu {
    private ManagerList managerList;
    
    public OwnerMenu(bookstk bookStock, Scanner scanner, StaffList staffList, ManagerList managerList) {
        super(bookStock, scanner, staffList);
        this.managerList = managerList;
    }

    @Override
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
                    addRemove.addBookFromInput();
                    break;
                case 2:
                    addRemove.removeBookFromInput();
                    break;
                case 3:
                    addRemove.displayBookStock();
                    break;
                case 4:
                    AddRemoveStaff addStaff = new AddRemoveStaff(super.staffList);
                    System.out.print("Enter staff name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter staff email: ");
                    String staffEmail = scanner.nextLine();
                    System.out.print("Enter staff password: ");
                    String staffPassword = scanner.nextLine();
                    addStaff.addStaff(staffName, staffEmail, staffPassword);
                    break;
                case 5:
                    AddRemoveStaff removeStaff = new AddRemoveStaff(super.staffList);
                    System.out.print("Enter staff name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    removeStaff.removeStaff(nameToRemove);
                    break;
                case 6:
                    AddRemoveManager addManager = new AddRemoveManager(managerList);
                    System.out.print("Enter manager name: ");
                    String managerName = scanner.nextLine();
                    System.out.print("Enter manager email: ");
                    String managerEmail = scanner.nextLine();
                    System.out.print("Enter manager password: ");
                    String managerPassword = scanner.nextLine();
                    addManager.addManager(managerName, managerEmail, managerPassword);
                    break;
                case 7:
                    AddRemoveManager removeManager = new AddRemoveManager(managerList);
                    System.out.print("Enter manager name to remove: ");
                    String nameToRemoves = scanner.nextLine();
                    removeManager.removeManager(nameToRemoves);
                    break;
                case 8:
                    AddRemoveStaff displayStaff = new AddRemoveStaff(super.staffList);
                    displayStaff.displayStaff();
                    break;
                case 9:
                    AddRemoveManager displayManager = new AddRemoveManager(managerList);
                    displayManager.displayManagers();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
