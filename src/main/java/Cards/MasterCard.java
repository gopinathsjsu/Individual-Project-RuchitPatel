package Cards;

import Cards.CreditCardValidator;

public class MasterCard extends CreditCardValidator {
        @Override
        public boolean isValidCard(String cardNumber) {
            String creditCard = cardNumber;

            String firstDigit = creditCard.substring(0,1);
            String secondDigit = creditCard.substring(1,2);

            if (creditCard.length() == 16  && firstDigit.equals("5")&&
                    (secondDigit.equals("1") || secondDigit.equals("2") || secondDigit.equals("3")|| secondDigit.equals("4")|| secondDigit.equals("5"))) {
                System.out.println("Master Card");
//                System.out.println(firstDigit);
//                System.out.println(secondDigit);

                return true;
            }
            else{
//                System.out.println(firstDigit);
//                System.out.println(secondDigit);
                return nextCard.isValidCard(cardNumber);
//                return false;
            }
        }
    }