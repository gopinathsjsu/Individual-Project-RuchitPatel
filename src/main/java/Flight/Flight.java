package Flight;

public class Flight {

    String category;
    String flightNumber;
    int seatAvailable;
    double price;
    String arrivalCity;
    String departureCity;


    public Flight(){
        //No argument constructor
    }

    public Flight(String category , String flightNumber, int seatAvailable,double price , String arrivalCity , String departureCity){
        this.category = category;
        this.flightNumber = flightNumber;
        this.seatAvailable = seatAvailable;
        this.price = price;
        this.arrivalCity = arrivalCity;
        this.departureCity=departureCity;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public void setSeatAvailable(int seatAvailable){
        this.seatAvailable = seatAvailable;
    }

    public int getSeatAvailable(){
        return this.seatAvailable;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setArrivalCity(String arrivalCity){
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalCity(){
        return this.arrivalCity;
    }

    public void setDepartureCity(String departureCity){
        this.departureCity = departureCity;
    }

    public String getDepartureCity(){
        return this.departureCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "category='" + category + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", seatAvailable=" + seatAvailable +
                ", price=" + price + '\'' +
                ", arrivalCity=" + arrivalCity + '\'' +
                ", departureCity=" + departureCity + '\'' +
                '}';
    }

}
