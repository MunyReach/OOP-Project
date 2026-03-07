package bookstore.User.Staff;

public class Owner extends User {
    
    public Owner(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String getRole() {
        return "Owner";
    }


}
