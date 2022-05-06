package Cards;

public class AmexCard extends CreditCardValidator {

    @Override
    public boolean isValidCard(String cardNumber) {
        String creditCard = cardNumber;

        String firstDigit = creditCard.substring(0,1);
        String secondDigit = creditCard.substring(1,2);

        if (creditCard.length() == 15  && firstDigit.equals("3")&&
                (secondDigit.equals("4") || secondDigit.equals("7") )) {
                 System.out.println("Amex Card");
                return true;
        }
        else if(creditCard.length()>19){
            System.out.println("Credit Card number greater than expected. ");
            return false;
        }
        else{
            System.out.println("It is not a Valid card");
            System.out.println(" ");
            return false;
        }
    }
}
