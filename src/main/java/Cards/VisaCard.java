package Cards;

import Cards.CreditCardValidator;

public class VisaCard extends CreditCardValidator {

    @Override
    public boolean isValidCard(String cardNumber) {
        String creditCard = cardNumber;

        String firstDigit = creditCard.substring(0,1);

        if ((creditCard.length() == 13 || creditCard.length() == 16)  && firstDigit.equals("4")){
            System.out.println("Visa Card");
            return true;
        }
        else{
            return nextCard.isValidCard(cardNumber);
        }
    }
}