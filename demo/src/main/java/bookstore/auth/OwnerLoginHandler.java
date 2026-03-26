package bookstore.auth;

import bookstore.User.Staff.Owner;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class OwnerLoginHandler implements LoginHandler {
    @Override
    public User login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (email.equals("owner@store.com") && password.equals("owner123")) {
            System.out.println("Owner login successful!\n");
            return new Owner("Owner", email, password);
        }

        System.out.println("Invalid email or password!\n");
        return null;
    }
}
