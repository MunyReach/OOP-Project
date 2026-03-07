package bookstore.auth;

import bookstore.User.Staff.Staff;
import bookstore.User.Staff.StaffList;
import bookstore.User.Staff.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffLoginHandler implements LoginHandler {
    private final StaffList staffList;

    public StaffLoginHandler() {
        this.staffList = createStaffList();
    }

    @Override
    public User login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User staff : staffList.getStaffMembers()) {
            if (staff.getEmail().equalsIgnoreCase(email) && staff.isPasswordCorrect(password)) {
                System.out.println("Staff login successful!\n");
                return staff;
            }
        }

        System.out.println("Invalid email or password!\n");
        return null;
    }

    private StaffList createStaffList() {
        List<User> staffMembers = new ArrayList<>();
        staffMembers.add(new Staff("A", "A@store.com", "A123"));
        staffMembers.add(new Staff("B", "B@store.com", "B123"));
        staffMembers.add(new Staff("C", "C@store.com", "C123"));
        return new StaffList(staffMembers);
    }
}
