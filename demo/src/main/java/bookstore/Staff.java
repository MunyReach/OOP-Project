package bookstore;
//Change by liya: write code inside class 

public class Staff extends User{
    private String password;


    public Staff(String name, String email, String password) {
        super(name, email, password);
        this.password = password;
    }
public void setPassword(String password) {
        this.password = password;
    }
private String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    
}
