package bookstore.User.Staff.AddRemoveDisplay;

import bookstore.User.Staff.ManagerList;
import bookstore.User.Staff.Manager;

public class AddRemoveManager {
    private ManagerList managerlist;

    public AddRemoveManager(ManagerList managerlist) {
        this.managerlist = managerlist;
    }

    public void addManager(String name, String email, String password) {
        Manager newManager = new Manager(name, email, password);
        managerlist.addManager(newManager);
        System.out.println("Manager added: " + name);
    }

    public void removeManagerById(int id) {
        Manager managerToRemove = null;
        for (Manager manager : managerlist.getManagers()) {
            if (manager.getId() == id) {
                managerToRemove = manager;
                break;
            }
        }

        if (managerToRemove != null) {
            managerlist.removeManager(managerToRemove);
        } else {
            System.out.println("Manager not found with ID: " + id);
        }
    }

    // Keep the name-based method for compatibility, but prefer ID based removal.
    public void removeManager(String name) {
        Manager managerToRemove = null;
        for (Manager manager : managerlist.getManagers()) {
            if (manager.getName().equals(name)) {
                managerToRemove = manager;
                break;
            }
        }

        if (managerToRemove != null) {
            managerlist.removeManager(managerToRemove);
        } else {
            System.out.println("Manager not found with name: " + name);
        }
    }

    public void displayManagers() {
        if (managerlist.getManagers().isEmpty()) {
            System.out.println("No managers found.");
        } else {
            System.out.println("\n=== Manager List ===");
            for (Manager manager : managerlist.getManagers()) {
                     System.out.println("ID: " + manager.getFormattedId() + " | Name: " + manager.getName() + " | Email: " + manager.getEmail());
            }
            System.out.println("====================\n");
        }
    }
}