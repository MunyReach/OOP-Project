package bookstore;

public class Manager extends User{
    
    public Staff(String name, String email) {
        super(name, email);
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle());
    }
}

