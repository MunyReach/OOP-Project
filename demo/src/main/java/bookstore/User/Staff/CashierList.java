package bookstore.User.Staff;

import java.util.List;

public class CashierList {
    
    private List<User> cashierMembers;

    public CashierList(List<User> cashierMembers) {
        this.cashierMembers = cashierMembers;
        updateCashierIds();
    }

    public void addCashierMember(User cashier) {
        cashierMembers.add(cashier);
        updateCashierIds();
        System.out.println("Cashier member added: " + cashier.getName());
    }

    public void removeCashierMember(User cashier) {
        if (cashierMembers.contains(cashier) && cashier.getRole().equals("Cashier")) {
            cashierMembers.remove(cashier);
            updateCashierIds();
            System.out.println("Cashier member removed: " + cashier.getName());
        } else {
            System.out.println("Cashier member not found: " + cashier.getName());
        }
    }

    public List<User> getCashierMembers() {
        return cashierMembers;
    }

    private void updateCashierIds() {
        for (int i = 0; i < cashierMembers.size(); i++) {
            cashierMembers.get(i).setId(i + 1);
        }
    }
}
