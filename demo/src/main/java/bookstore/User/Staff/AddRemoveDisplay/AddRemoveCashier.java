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
                System.out.println("- " + cashier.getName() + " (" + cashier.getEmail() + ")");
            }
            System.out.println("==================\n");
        }
    }

    public void addCashierFromInput(Scanner scanner) {
        // Clearing the buffer one time to prevent the "skipping" issue
        // scanner.nextLine(); // Uncomment this if the name prompt skips after you press '2'

        String name = "";
        String email = "";
        String password = "";

        while (true) {
            System.out.print("Enter Cashier Name: ");
            name = scanner.nextLine();

            if(name.length() > 0 && 
               name.length() < 52 && 
               Character.isUpperCase(name.charAt(0)) && 
               name.substring(1).equals(name.substring(1).toLowerCase())) {
                break;
            }
            System.out.println("Invalid! Name must start with a Capital (first letter only), and not all lowercase/highercase.");
        }

        while (true) {
            System.out.print("Enter Cashier Email: ");
            email = scanner.nextLine();


            if (email.matches("^[A-Za-z0-9+_.-]+@store\\.com$")) {
                break;
            }
            System.out.println("Invalid email! Please use standard format ");
        }


        while (true) {
            System.out.print("Enter Cashier Password: ");
            password = scanner.nextLine();

            boolean hasLetter = password.matches(".*[a-zA-Z].*");
            boolean hasNumber = password.matches(".*[0-9].*");

            if (hasLetter && hasNumber) {
                break;
            }
            System.out.println("Invalid! Password must contain both numbers and letters.");
        }

        // 4. Authorized: Save and create the Gap
        addCashier(name, email, password);
        System.out.println("Cashier '" + name + "' added successfully.");
        
        System.out.println("\n\n\n"); 
    }
}