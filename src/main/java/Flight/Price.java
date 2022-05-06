package Flight;
import Flight.Flight;
import Flight.FlightData;
import Flight.InputFile;

import java.util.ArrayList;

public class Price {

    public double totalPrice(InputFile inputfile, FlightData dbInstance) {

        String flightNumber = inputfile.getFlightNumber();
        int seatAvailability = inputfile.getNumberOfSeats();
        String category = inputfile.getSeatCategory();

        ArrayList<Flight> flightArrayList = dbInstance.getFlightArrayList();

        for (Flight entry : flightArrayList) {
            if (entry.getFlightNumber().equalsIgnoreCase(flightNumber) && entry.getCategory().equalsIgnoreCase(category)) {
                double finalPrice = seatAvailability * entry.getPrice();
                System.out.println("Total Price for the seats" + " $" + finalPrice);
                return finalPrice;
            }
        }
        return 0.0;
    }
}


