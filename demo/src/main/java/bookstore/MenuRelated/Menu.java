package bookstore.MenuRelated;

import bookstore.User.Staff.User;


public class Menu {
    public void DisplayMenu(User user) {
        System.out.println("=================MENU==================");
        if(user.getRole().equals("Owner")) {
            System.out.println("1. Add Books");
            System.out.println("2. Remove Books");
            System.out.println("3. Display book stock");
            System.out.println("4. Add Staff");
            System.out.println("5. Remove Staff");
            System.out.println("6. Add Manager");
            System.out.println("7. Remove Manager");
            System.out.println("8. Display Staff");
            System.out.println("9. Display Manager");
            System.out.println("0. Exit");
        }

        if(user.getRole().equals("Manager")) {
            System.out.println("1. Add Books");
            System.out.println("2. Remove Books");
            System.out.println("3. Display book stock");
            System.out.println("4. Add Staff");
            System.out.println("5. Remove Staff");
            System.out.println("6. Display Staff");
            System.out.println("0. Exit");
        }
        
        if(user.getRole().equals("Staff")) {
            System.out.println("1. Make Order");
            System.out.println("2. Add Books");
            System.out.println("3. Remove Books");
            System.out.println("4. Display book stock");
            System.out.println("0. Exit");
        }
    }

    public void DisplayBeforeLogin() {
        System.out.println("=================MENU==================");
        System.out.println("1.Login as Owner");
        System.out.println("2.Login as Manager");
        System.out.println("3.Login as Staff");
        System.out.println("0.Exit");
    }
}
