package bookstore.User.Staff;

import java.util.List;

public class ManagerList {
    private List<Manager> managers;

    public ManagerList(List<Manager> managers) {
        this.managers = managers;
    }

    public void addManager(Manager manager) {
        managers.add(manager);
        System.out.println("Manager added: " + manager.getName());
    }

    public void removeManager(Manager manager) {
        if(managers.contains(manager)) {
            System.out.println("Manager removed: " + manager.getName());
        } else {
            System.out.println("Manager not found: " + manager.getName());
        }
        managers.remove(manager);
    }

    public List<Manager> getManagers() {
        return managers;
    }
}
