package bookstore.defaults;

import bookstore.User.Staff.Staff;
import bookstore.User.Staff.User;
import java.util.ArrayList;
import java.util.List;

public final class DefaultStaffData {
    private DefaultStaffData() {
    }

    public static List<User> createDefaultStaffMembers() {
        List<User> staffMembers = new ArrayList<>();
        staffMembers.add(new Staff("A", "A@store.com", "A123"));
        staffMembers.add(new Staff("B", "B@store.com", "B123"));
        staffMembers.add(new Staff("C", "C@store.com", "C123"));
        return staffMembers;
    }
}
