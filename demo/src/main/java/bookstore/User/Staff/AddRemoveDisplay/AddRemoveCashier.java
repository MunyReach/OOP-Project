package bookstore.User.Staff.AddRemoveDisplay;

import java.util.Scanner;

import bookstore.User.Staff.Cashier;
import bookstore.User.Staff.CashierList;
import bookstore.User.Staff.User;

public class AddRemoveCashier {
    
    private final CashierList cashierList;
    
    public AddRemoveCashier(CashierList cashierList) {
        this.cashierList = cashierList;
    }

    public void addCashier(String name, String email, String password) {
        Cashier newCashier = new Cashier(name, email, password);
        cashierList.addCashierMember(newCashier);
        System.out.println("Added new cashier: " + newCashier.getName());
        
    }

    public void removeCashierById(int id) {
        User cashierToRemove = null;
        for (User cashier : cashierList.getCashierMembers()) {
            if (cashier.getId() == id) {
                cashierToRemove = cashier;
                break;
            }
        }

        if (cashierToRemove != null) {
            cashierList.removeCashierMember(cashierToRemove);
            System.out.println("Removed cashier: " + cashierToRemove.getName());
        } else {
            System.out.println("Cashier not found with ID: " + id);
        }
    }

    // Keep the name-based method for compatibility, but prefer ID based removal.
    public void removeCashier(String name) {
        User cashierToRemove = null;
        for (User cashier : cashierList.getCashierMembers()) {
            if (cashier.getName().equals(name)) {
                cashierToRemove = cashier;
                break;
            }
        }

        if (cashierToRemove != null) {
            cashierList.removeCashierMember(cashierToRemove);
            System.out.println("Removed cashier: " + cashierToRemove.getName());
        } else {
            System.out.println("Cashier not found with name: " + name);
        }
    }

    public void displayCashier() {
        if(cashierList.getCashierMembers().isEmpty()) {
            System.out.println("No cashier members found.");
        } else {
            System.out.println("\n=== Cashier List ===");
            for (User cashier : cashierList.getCashierMembers()) {
                System.out.println("- ID: " + cashier.getFormattedId() + " | " + cashier.getName() + " (" + cashier.getEmail() + ")");
            }
            System.out.println("==================\n");
        }
    }

    public void addCashierFromInput(Scanner scanner) {
        // scanner.nextLine(); // Uncomment this if the name prompt skips after you press '2'

        while (true) {
            System.out.println("Name format: First letter capital, rest lowercase (e.g., Alice)");
            System.out.print("Enter Cashier Name: ");
            String name = scanner.nextLine();

            if (!isValidName(name)) {
                System.out.println("Invalid! Please follow the correct name format.");
                if (!askRetryOrReturn(scanner)) {
                    return;
                }
                continue;
            }

            System.out.println("Email format: username@store.com (e.g., alice@store.com)");
            System.out.print("Enter Cashier Email: ");
            String email = scanner.nextLine();

            if (!isValidEmail(email)) {
                System.out.println("Invalid email format! Please use username@store.com.");
                if (!askRetryOrReturn(scanner)) {
                    return;
                }
                continue;
            }

            System.out.print("Enter Cashier Password: ");
            String password = scanner.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Invalid! Password must contain both letters and numbers.");
                if (!askRetryOrReturn(scanner)) {
                    return;
                }
                continue;
            }

            addCashier(name, email, password);
            System.out.println("Cashier '" + name + "' added successfully.");
            System.out.println("\n\n\n");
            return;
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