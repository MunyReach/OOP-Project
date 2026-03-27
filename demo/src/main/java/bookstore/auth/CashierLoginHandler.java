package bookstore.auth;

import java.util.Scanner;

import bookstore.User.Staff.CashierList;
import bookstore.User.Staff.User;
import bookstore.defaults.DefaultStaffData;

public class CashierLoginHandler implements LoginHandler {
    private final CashierList cashierList;

    public CashierLoginHandler(CashierList cashierList) {
        this.cashierList = cashierList;
    }

    public CashierLoginHandler() {
        this.cashierList = new CashierList(DefaultStaffData.createDefaultStaffMembers());
    }

    @Override
    public User login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User cashier : cashierList.getCashierMembers()) {
            if (cashier.getEmail().equalsIgnoreCase(email) && cashier.isPasswordCorrect(password)) {
                System.out.println("Cashier login successful!\n");
                return cashier;
            }
        }

        System.out.println("Invalid email or password!\n");
        return null;
    }

}
