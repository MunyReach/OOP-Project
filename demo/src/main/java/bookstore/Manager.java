package bookstore;
//Change by Liya: matching constrctor and class name (staff to Manager)
public class Manager extends User{
    
    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void addBook(Book book) {
        System.out.println("Book added: " + book.getTitle());
    }
}

