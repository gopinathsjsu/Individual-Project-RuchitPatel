package Flight;

public class InputFile {
    String name;
    String flightNumber;
    String seatCategory;
    int numberOfSeats;
    String paymentCardNumber;

    public InputFile(String bookingName, String flightNumber,String seatCategory ,  int numberOfSeats, String paymentCardNumber ){
        this.name = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.numberOfSeats = numberOfSeats;
        this.paymentCardNumber = paymentCardNumber;

    }

    public InputFile() {
        //No argument constructor.
    }

    public String getName(){
        return this.name;
    }

    public void setBookingName(String bookingName){
        this.name = bookingName;

    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;

    }

    public String getSeatCategory(){
        return this.seatCategory;
    }

    public void setSeatCategory(String seatCategory){
        this.seatCategory = seatCategory;

    }
    public int getNumberOfSeats(){
        return this.numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
    }

    public void setCreditCardNumber(String creditCardNumber){
        this.paymentCardNumber = creditCardNumber;

    }

    public String getPaymentCardNumber(){
        return this.paymentCardNumber;
    }




}
