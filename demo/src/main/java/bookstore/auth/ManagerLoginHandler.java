package bookstore.auth;

import bookstore.User.Staff.Manager;
import bookstore.User.Staff.User;
import java.util.Scanner;

public class ManagerLoginHandler implements LoginHandler {
    @Override
    public User login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (email.equals("manager@store.com") && password.equals("manager123")) {
            System.out.println("Manager login successful!\n");
            return new Manager("Manager", email, password);
        }

        System.out.println("Invalid email or password!\n");
        return null;
    }
}
