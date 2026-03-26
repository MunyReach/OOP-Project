package bookstore.defaults;

import bookstore.User.Staff.Manager;
import java.util.ArrayList;
import java.util.List;

public final class DefaultManagerData {
    private DefaultManagerData() {
    }

    public static List<Manager> createDefaultManagers() {
        List<Manager> managers = new ArrayList<>();
        managers.add(new Manager("Manager", "manager@store.com", "manager123"));
        return managers;
    }
}
