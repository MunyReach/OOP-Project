package bookstore.auth;

import bookstore.User.Staff.Staff;
import bookstore.User.Staff.StaffList;
import bookstore.User.Staff.User;
import bookstore.defaults.DefaultStaffData;
import java.util.Scanner;

public class StaffLoginHandler implements LoginHandler {
    private final StaffList staffList;

    public StaffLoginHandler(StaffList staffList) {
        this.staffList = staffList;
    }

    public StaffLoginHandler() {
        this.staffList = new StaffList(DefaultStaffData.createDefaultStaffMembers());
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
        return new StaffList(DefaultStaffData.createDefaultStaffMembers());
    }
}
