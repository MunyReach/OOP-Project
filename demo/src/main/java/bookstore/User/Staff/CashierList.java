package bookstore.User.Staff;

import java.util.List;

public class CashierList {
    
    private List<User> cashierMembers;

    public CashierList(List<User> cashierMembers) {
        this.cashierMembers = cashierMembers;

    }

    public void addCashierMember(User cashier) {
        cashierMembers.add(cashier);
        System.out.println("Cashier member added: " + cashier.getName());
    }

    public void removeCashierMember(User cashier) {
        if(cashierMembers.contains(cashier) && cashier.getRole().equals("Cashier")) {
            System.out.println("Cashier member removed: " + cashier.getName());
        } else {
            System.out.println("Cashier member not found: " + cashier.getName());
        }

        cashierMembers.remove(cashier);

    }

    public List<User> getCashierMembers() {
        return cashierMembers;
    }
}
