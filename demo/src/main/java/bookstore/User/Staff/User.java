package bookstore.User.Staff;

public abstract class User {
    protected String name;
    protected String email;
    private String password;


    public User(String name, String email, String password)  {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    private String getPassword() { return password; }

    public boolean isPasswordCorrect(String inputPassword) {
        return password.equals(inputPassword);
    }



    public abstract String getRole();

    //
    
}
