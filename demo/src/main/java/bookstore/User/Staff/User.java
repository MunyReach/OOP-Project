package bookstore.User.Staff;

public abstract class User implements OrderPermission {
    protected String name;
    protected String email;
    private String password;
    private int id;


    public User(String name, String email, String password)  {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = 0; // assigned by list controller
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    private String getPassword() { return password; }

    public boolean isPasswordCorrect(String inputPassword) {
        return password.equals(inputPassword);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFormattedId() {
        return String.format("%04d", id);
    }

    public static boolean isValidId(String idStr) {
        if (idStr == null || idStr.length() != 4) return false;
        try {
            int idNum = Integer.parseInt(idStr);
            return idNum >= 1 && idNum <= 9999;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public abstract String getRole();

    @Override
    public abstract boolean canMakeOrder();

    //
    
}
