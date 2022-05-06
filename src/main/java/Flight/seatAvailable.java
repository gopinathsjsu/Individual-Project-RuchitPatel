package Flight;

import java.util.ArrayList;

public class seatAvailable implements validators {

    String flightNumber = null;
    int seatRequested = 0;
    String category = null;
    ArrayList<Flight> flightInventory = new ArrayList<>();
    String flightKey = null;
    int seatAvailable = 0;

    @Override
    public boolean validate(InputFile inputFile, FlightData dbInstance) {
        //check seat availability
        flightNumber = inputFile.getFlightNumber();
        seatRequested = inputFile.getNumberOfSeats();
        category = inputFile.getSeatCategory();

        flightInventory = dbInstance.getFlightArrayList();
        for (Flight entry : flightInventory) {
            if (entry.getFlightNumber().equalsIgnoreCase(flightNumber)
                    && entry.getCategory().equalsIgnoreCase(category)) {
//                flightKey = entry.getKey();
                flightKey = entry.getFlightNumber();
                seatAvailable = entry.getSeatAvailable();

                if (seatRequested <= seatAvailable) {
                    System.out.println(seatAvailable + " Seats Available" + " " +
                            "for the flight" + " " + inputFile.getFlightNumber() + " " + "in " +
                            inputFile.getSeatCategory());

                    return true;

                }
            }
        }
        System.out.println("We don't have seats available that you requested");
        return false;
    }

    public void updateSeat() {
        for (Flight entry : flightInventory) {
            if (entry.getFlightNumber().equalsIgnoreCase(flightNumber) && entry.getCategory().equalsIgnoreCase(category)){
                entry.setSeatAvailable(seatAvailable - seatRequested);
//                System.out.println("Flight Number" + " " + entry.getFlightNumber());
                System.out.println("Number of Seat Available now" + " " + entry.getSeatAvailable());
                System.out.println(" ");

            }
        }
    }
}