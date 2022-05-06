package Cards;

public abstract class CreditCardValidator {
    public CreditCardValidator nextCard;

    public void SetCreditCard(CreditCardValidator nextCard) {
        this.nextCard = nextCard;
    }

    public abstract boolean isValidCard(String cardNumber);

}
