package bookstore.User.Staff;

public class Staff extends User {
    public Staff(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String getRole() {
        return "Staff";
    }
}
