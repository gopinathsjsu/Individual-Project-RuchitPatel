package test;

import Cards.CardChain;
import Flight.FlightData;
import Flight.InputFile;
import Flight.Price;
import Flight.seatAvailable;
import ReaderWriter.CSVtoJSON;
import ReaderWriter.ReadInput;
import Flight.validateFlight;
import ReaderWriter.PropertiesReader;
import ReaderWriter.CSVWrite;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RunClient {


    public static void main(String[] args) throws IOException {
        System.out.println("This is the flight booking app");
        CSVWrite writeTocsv = new CSVWrite();
      try {
          //Read Input CSV File and Flight use JVM parameters
          PropertiesReader pr = new PropertiesReader();
          pr.loadPropertiesFile();
          PropValue.MainConfig = pr.prop;
          if (args.length > 0) {
              PropValue.MainConfig.setProperty("INPUTFILE", args[0]);
              PropValue.MainConfig.setProperty("FLIGHTDATA", args[1]);
              PropValue.MainConfig.setProperty("OUTPUTFILE", args[2]);
              PropValue.MainConfig.setProperty("ERRORFILE", args[3]);

          }
          PropValue.outputRecord = new LinkedList<>();
          executeApp();
          //write to an output file.
          writeTocsv.addRecordToCSV(PropValue.outputRecord);
          //write to an error file
          writeTocsv.addRecordToErrorFile(PropValue.errorRecord);
      }
        catch(Exception e){
            e.printStackTrace();
          }
    }

    public static void executeApp() throws IOException {
        ReadInput csv = new ReadInput();
        InputFile bookingRecord = new InputFile();
        validateFlight checkflight = new validateFlight();
        seatAvailable checkseat = new seatAvailable();
        FlightData dbInstance = new FlightData();
        CardChain cardChain = new CardChain();
        Price pr = new Price();
        CSVtoJSON.Output write = new CSVtoJSON.Output();
        CSVWrite.ErrorReason error = new CSVWrite.ErrorReason();
        double finalPrice = 0.00;
        ObjectMapper mapper;
        String path = System.getProperty("user.dir")+"/src/main/java/InputFiles/";
        String csvFile = PropValue.MainConfig.getProperty("INPUTFILE");
        List<Map<?,?>> bookinglist =  csv.convertCsv(path+csvFile);
        String errorReason = null;

        //set the flight inventory and payment card
        dbInstance.setFlightInventory(PropValue.MainConfig.getProperty("FLIGHTDATA"));
        for(int i = 0 ; i<bookinglist.size();i++) {
            //process each row of CSV now and deserialize into InputFile Class.
            mapper = new ObjectMapper();
            bookingRecord = mapper.convertValue(bookinglist.get(i), InputFile.class);

            //verify valid Details
            if (checkflight.validate(bookingRecord, dbInstance)) {
                //verify seat availability
                if (checkseat.validate(bookingRecord, dbInstance)) {
                    //calculate price
                    finalPrice = pr.totalPrice(bookingRecord, dbInstance);
                } else {
                    //write to  error file invalid seats
                    errorReason = "Sorry, not enough seat available";
                    error.writeToFile(bookingRecord.getName(),bookingRecord.getFlightNumber(), errorReason,
                            Integer.toString(bookingRecord.getNumberOfSeats()) ,Double.toString(finalPrice));
                    continue;
                }

             } else {
                //add record for Invalid flight number in output.txt
                errorReason = "Please check the flight number";
                error.writeToFile(bookingRecord.getName(),bookingRecord.getFlightNumber(), errorReason,
                        Integer.toString(bookingRecord.getNumberOfSeats()) ,Double.toString(finalPrice));
                continue;

            }

            //Card validation

             if(cardChain.cardValidation(bookingRecord.getPaymentCardNumber())){
                 //modify the seat availability
                 checkseat.updateSeat();
                 //add processed record to List<String[]>
                 write.writeToFile(bookingRecord.getName(),bookingRecord.getFlightNumber(), bookingRecord.getSeatCategory(),
                         Integer.toString(bookingRecord.getNumberOfSeats()) ,Double.toString(finalPrice));
             }
             else{
                 //write to Output.txt file
                 errorReason = "Please check the card number";
                 error.writeToFile(bookingRecord.getName(),bookingRecord.getFlightNumber(), errorReason,
                         Integer.toString(bookingRecord.getNumberOfSeats()) ,Double.toString(finalPrice));
             }
        }
    }
}
