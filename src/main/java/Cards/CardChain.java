package Cards;

public class CardChain {
    public static VisaCard visa = new VisaCard();
    public static MasterCard master = new MasterCard();
    public static DiscoverCard discover = new DiscoverCard();
    public static AmexCard amex = new AmexCard();

    static{
       visa.SetCreditCard(master);
       master.SetCreditCard(discover);
       discover.SetCreditCard(amex);
    }

    public boolean cardValidation(String cardNumber){
        return visa.isValidCard(cardNumber);
    }

}
