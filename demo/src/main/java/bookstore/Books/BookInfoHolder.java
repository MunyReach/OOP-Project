package bookstore.Books;

public class BookInfoHolder {
    //Setting up books
    
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 10.99);
        book1.setGenre("Classic");
        

        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", 7.99);
        book2.setGenre("Fiction");
       

        Book book3 = new Book("1984", "George Orwell", "978-0451524935", 9.99);
        book3.setGenre("Dystopian");
       

        public void displayBooks() {
            book1.displayInfo();
            book2.displayInfo();
            book3.displayInfo();
        }
}
