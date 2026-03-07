package bookstore;
private String password;
public class Staff extends User{
    public Staff(String name, String email) {
        super(name, email);
    }
public setPassword(String password) {
        this.password = password;
    }
private String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle());
    }
}
