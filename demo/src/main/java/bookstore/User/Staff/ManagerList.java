package bookstore.User.Staff;

import java.util.List;

public class ManagerList {
    private List<Manager> managers;

    public ManagerList(List<Manager> managers) {
        this.managers = managers;
        updateManagerIds();
    }

    public void addManager(Manager manager) {
        managers.add(manager);
        updateManagerIds();
        System.out.println("Manager added: " + manager.getName());
    }

    public void removeManager(Manager manager) {
        if (managers.contains(manager)) {
            managers.remove(manager);
            updateManagerIds();
            System.out.println("Manager removed: " + manager.getName());
        } else {
            System.out.println("Manager not found: " + manager.getName());
        }
    }

    public List<Manager> getManagers() {
        return managers;
    }

    private void updateManagerIds() {
        for (int i = 0; i < managers.size(); i++) {
            managers.get(i).setId(i + 1);
        }
    }
}
