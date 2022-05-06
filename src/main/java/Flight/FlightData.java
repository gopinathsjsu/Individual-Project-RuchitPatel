package Flight;

import ReaderWriter.CSVtoJSON;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;

public class FlightData {

    ArrayList<Flight> flightArrayList = new ArrayList<>();

    final static String path = System.getProperty("user.dir")+"/src/main/java/Inputfiles";

    public FlightData(){
        //No argument constructor
    }

     public  void setFlightInventory(String csvFile){

        List<Map<?,?>> list = CSVtoJSON.readCsvToJson(path+"/"+csvFile);
        Flight flight = new Flight();
        for(int i = 0 ; i<list.size();i++){
            final ObjectMapper mapper = new ObjectMapper();
            flight = mapper.convertValue(list.get(i), Flight.class);
            flightArrayList.add(flight);
        }
    }

    public ArrayList<Flight> getFlightArrayList(){
        return flightArrayList;
    }


}
