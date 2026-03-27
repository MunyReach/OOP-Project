package bookstore.User.Staff.AddRemoveDisplay;

import bookstore.User.Staff.User;
import bookstore.User.Staff.Cashier;
import bookstore.User.Staff.CashierList;

public class AddRemoveCashier {
    
    private CashierList cashierList;
    
    public AddRemoveCashier(CashierList cashierList) {
        this.cashierList = cashierList;
    }

    public void addCashier(String name, String email, String password) {
        // In a real application, you would save this to a database
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

}
