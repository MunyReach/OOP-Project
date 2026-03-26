package bookstore.defaults;

import bookstore.User.Staff.Cashier;
import bookstore.User.Staff.User;
import java.util.ArrayList;
import java.util.List;

public final class DefaultStaffData {
    private DefaultStaffData() {
    }

    public static List<User> createDefaultStaffMembers() {
        List<User> cashierMembers = new ArrayList<>();
        cashierMembers.add(new Cashier("A", "A@store.com", "A123"));
        cashierMembers.add(new Cashier("B", "B@store.com", "B123"));
        cashierMembers.add(new Cashier("C", "C@store.com", "C123"));
        return cashierMembers;
    }
}
