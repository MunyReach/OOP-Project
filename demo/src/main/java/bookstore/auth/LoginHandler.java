package bookstore.auth;

import bookstore.User.Staff.User;
import java.util.Scanner;

public interface LoginHandler {
    User login(Scanner scanner);
}
