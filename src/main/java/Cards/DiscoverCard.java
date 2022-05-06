package Cards;

import Cards.CreditCardValidator;

public class DiscoverCard extends CreditCardValidator {


    @Override
    public boolean isValidCard(String cardNumber) {
        String creditCard = cardNumber;

        String firstFourDigit = creditCard.substring(0,4);
        if (creditCard.length() == 16  && firstFourDigit.equals("6011")){
            System.out.println("Discover Card");
//            System.out.println(firstFourDigit);
            return true;
        }
        else{
            return nextCard.isValidCard(cardNumber);
//            System.out.println("It is not a Valid card");
//            System.out.println(firstFourDigit);
//            return false;
        }
    }

}
