package bookstore.auth;

import bookstore.User.Staff.Manager;
import bookstore.User.Staff.ManagerList;
import bookstore.User.Staff.User;
import bookstore.defaults.DefaultManagerData;
import java.util.Scanner;

public class ManagerLoginHandler implements LoginHandler {
    private final ManagerList managerList;

    public ManagerLoginHandler(ManagerList managerList) {
        this.managerList = managerList;
    }

    public ManagerLoginHandler() {
        this.managerList = new ManagerList(DefaultManagerData.createDefaultManagers());
    }

    @Override
    public User login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Manager manager : managerList.getManagers()) {
            if (manager.getEmail().equalsIgnoreCase(email) && manager.isPasswordCorrect(password)) {
                System.out.println("Manager login successful!\n");
                return manager;
            }
        }

        System.out.println("Invalid email or password!\n");
        return null;
    }
}
