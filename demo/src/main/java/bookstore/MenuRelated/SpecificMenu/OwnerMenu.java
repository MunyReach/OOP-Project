package bookstore.MenuRelated.SpecificMenu;

import java.util.Scanner;

import bookstore.User.Staff.AddRemoveDisplay.AddRemoveBook;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveCashier;
import bookstore.User.Staff.AddRemoveDisplay.AddRemoveManager;
import bookstore.User.Staff.CashierList;
import bookstore.User.Staff.ManagerList;
import bookstore.User.Staff.User;
import bookstore.book.bookstk;

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
                    AddRemoveBook addRemove = new AddRemoveBook(bookStock, scanner, managerList);
                    addRemove.displayTotalBookStock();

                    // Option to continue to menu or logout
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Continue to menu");
                    System.out.println("2. Logout");

                    System.out.print("Enter your choice: ");

                    int option = scanner.nextInt();
                    scanner.nextLine();


                    while(option != 1 && option != 2) {
                        System.out.println("Invalid option! Please enter 1 or 2.");
                        System.out.print("Choose an option: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.nextLine();
                            continue;
                        }
                        option = scanner.nextInt();
                        scanner.nextLine();
                    }

                    if (option == 1) {
                        System.out.println("\n"); 
                        continue;
                    }else{
                        System.out.println("Logging out...\n");
                        return;
                    }

                case 2:
                    // Add Cashier
                    AddRemoveCashier arc = new AddRemoveCashier(this.cashierList);
                    arc.addCashierFromInput(scanner);
                    break;
                case 3:
                    // Remove Cashier by ID
                    AddRemoveCashier removeCashier = new AddRemoveCashier(cashierList);
                    System.out.print("Enter cashier ID to remove (numeric): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid ID. Please enter a number.");
                        scanner.nextLine();
                        break;
                    }
                    int cashierIdRemove = scanner.nextInt();
                    scanner.nextLine();
                    removeCashier.removeCashierById(cashierIdRemove);
                    break;
                case 4:
                    // Add Manager
                    AddRemoveManager addManager = new AddRemoveManager(managerList);
                    while (true) {
                        System.out.println("Name format: First letter capital, rest lowercase (e.g., Alice)");
                        System.out.print("Enter manager name: ");
                        String managerName = scanner.nextLine();

                        if (!isValidName(managerName)) {
                            System.out.println("Invalid! Please follow the correct name format.");
                            if (!askRetryOrReturn(scanner)) {
                                break;
                            }
                            continue;
                        }

                        System.out.println("Email format: username@store.com (e.g., alice@store.com)");
                        System.out.print("Enter manager email: ");
                        String managerEmail = scanner.nextLine();

                        if (!isValidEmail(managerEmail)) {
                            System.out.println("Invalid email format! Please use username@store.com.");
                            if (!askRetryOrReturn(scanner)) {
                                break;
                            }
                            continue;
                        }

                        System.out.print("Enter manager password: ");
                        String managerPassword = scanner.nextLine();

                        if (!isValidPassword(managerPassword)) {
                            System.out.println("Invalid password! Password must contain both letters and numbers.");
                            if (!askRetryOrReturn(scanner)) {
                                break;
                            }
                            continue;
                        }

                        addManager.addManager(managerName, managerEmail, managerPassword);
                        System.out.println("Manager '" + managerName + "' added successfully.");
                        break;
                    }
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

    private boolean isValidName(String name) {
        return name.length() > 0 && name.length() < 52 && Character.isUpperCase(name.charAt(0))
                && name.substring(1).equals(name.substring(1).toLowerCase());
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@store\\.com$");
    }

    private boolean isValidPassword(String password) {
        return password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*");
    }

    private boolean askRetryOrReturn(Scanner scanner) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Try again");
            System.out.println("2. Return to owner menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Invalid choice! Please enter 1 or 2.");
            }
        }
    }
}
