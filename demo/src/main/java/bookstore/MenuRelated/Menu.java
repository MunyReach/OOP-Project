package bookstore.MenuRelated;

import bookstore.User.Staff.User;


public class Menu {
    public void DisplayMenu(User user) {
        System.out.println("=================MENU==================");
        if(user.getRole().equals("Owner")) {
            System.out.println("1. Display book stock");
            System.out.println("2. Add cashier");
            System.out.println("3. Remove cashier");
            System.out.println("4. Add Manager");
            System.out.println("5. Remove Manager");
            System.out.println("6. Display cashier");
            System.out.println("7. Display Manager");
            System.out.println("0. Logout");
        }

        if(user.getRole().equals("Manager")) {
            System.out.println("1. Display book stock");
            System.out.println("2. Display Sale");
            System.out.println("3. Add book");
            System.out.println("4. Remove book");
            System.out.println("0. Logout");
        }
        
        if(user.getRole().equals("Cashier")) {
            System.out.println("1. Make order");
            System.out.println("2. Display Book stock");
            System.out.println("3. Display Sale");
            System.out.println("0. Logout");
        }
    }

    public void DisplayBeforeLogin() {
        System.out.println("=================MENU==================");
        System.out.println("1.Login as Owner");
        System.out.println("2.Login as Manager");
        System.out.println("3.Login as Cashier");
        System.out.println("0.Exit");
    }
}
