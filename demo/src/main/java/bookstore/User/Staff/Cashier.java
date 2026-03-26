package bookstore.User.Staff;

public class Cashier extends User {
    public Cashier(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String getRole() {
        return "Cashier";
    }

    @Override
    public boolean canMakeOrder() {
        return true;
    }
}
