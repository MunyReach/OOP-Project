package bookstore.MenuRelated;

import bookstore.User.Staff.User;


public class Menu {
    public void DisplayMenu(User user) {
        System.out.println("=================MENU==================");
        System.out.println("1.Buy Books");

        if(user.getRole().equals("Owner")) {
            System.out.println("2. Add Books");
            System.out.println("3. Remove Books");
            System.out.println("4. Display book stock");
            System.out.println("5. Add Staff");
            System.out.println("6. Remove Staff");
            System.out.println("7. Add Manager");
            System.out.println("8. Remove Manager");
            System.out.println("9. Display Staff");
            System.out.println("10. Display Manager");
            System.out.println("0. Exit");
        }

        if(user.getRole().equals("Manager")) {
            System.out.println("2. Add Books");
            System.out.println("3. Remove Books");
            System.out.println("4. Display book stock");
            System.out.println("5. Add Staff");
            System.out.println("6. Remove Staff");
            System.out.println("7. Display Staff");
            System.out.println("0. Exit");
        }
        
        if(user.getRole().equals("Staff")) {
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
        System.out.println("4.Buy Books");
        System.out.println("0.Exit");
    }
}
