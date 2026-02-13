package bookstore.MenuRelated.Buying;

import bookstore.App;

public class BuyMoreBook {
    public void askToBuyMore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to buy more books? (y/n)");
        String response = scanner.nextLine();
        
        if(response.equalsIgnoreCase("y")) {
            BuyBooks buyBooks = new BuyBooks();
            buyBooks.displayBooksForSale();
        } else {
            System.out.println("Thank you for shopping with us!");
            App app = new App();
            app.main(null); // Return to main menu
        }
    }
}
