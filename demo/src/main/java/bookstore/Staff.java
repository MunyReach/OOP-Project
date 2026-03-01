package bookstore;

public class Staff extends User{
    public Staff(String name, String email) {
        super(name, email);
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle());
    }
}
