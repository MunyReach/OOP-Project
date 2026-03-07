package bookstore;

public class CardPayment implements PaymentMethod{
    private String cardNumber;

    public CardPayment(String cardNumber) {
        setCardNumber(cardNumber);
    }
    public final void setCardNumber(String cardNumber){
        if(cardNumber != null && cardNumber.length() ==19){
            this.cardNumber = cardNumber;
        }else{
            this.cardNumber = "Invalid Card";
            System.out.println("Invalid card number! Please Enter The Correct Digits");
        }
    }
    @Override
    public boolean pay(double amount) {
        if(this.cardNumber.equals("Invalid Card")){
            System.out.println("Payment failed due to invalid card number.");
            return false;
        }
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        String maskedCard = "****-****-****-" + lastFour;
        System.out.println("Processing Credit Card (" + maskedCard + ") for $" + amount);
        return true;
    }
}
