package bookstore;

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



    public abstract String getRole();
}
