package Flight;

import java.util.ArrayList;

public class validateFlight implements validators {


    @Override
    public boolean validate(InputFile inputFile, FlightData dbInstance) {
        String flightNumber = inputFile.getFlightNumber();

        //check from the Flight staticDb if flight number exist

        ArrayList<Flight> flightInventory = dbInstance.getFlightArrayList();
        for (Flight entry : flightInventory) {
            if (entry.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                System.out.println(entry.getFlightNumber() + " is a valid flight");
                return true;
            }
        }
        System.out.println("This is not a Valid Flight Number"+" "+flightNumber);
        return false;
    }
}
