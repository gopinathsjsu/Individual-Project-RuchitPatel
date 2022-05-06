import Cards.CardChain;
import Flight.FlightData;
import Flight.InputFile;
import Flight.Price;
import ReaderWriter.CSVtoJSON;
import ReaderWriter.ReadInput;
import Flight.validateFlight;
import Flight.seatAvailable;
import ReaderWriter.PropertiesReader;
import ReaderWriter.CSVWrite;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import test.PropValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class unitTests {

    ReadInput input;
    String inputFile ;
    String flightFile;
    ObjectMapper mapper ;
    List<Map<?,?>> bookingList = new ArrayList<>();
    FlightData data;
    seatAvailable check;

    validateFlight Flight;

    Price price;

    InputFile testRecord;

    double finalPrice = 0.0;
    PropertiesReader pr;

    @Before
    public void setup() throws IOException {
        input = new ReadInput();
        data =  new FlightData();
        inputFile = System.getProperty("user.dir")+"/src/main/java/InputFiles/test.csv";
        bookingList =  input.convertCsv(inputFile);
        mapper = new ObjectMapper();
        flightFile = "Flight.csv";
        //set Flight inventory
        data.setFlightInventory(flightFile);
        data.getFlightArrayList();
        testRecord = mapper.convertValue(bookingList.get(0), InputFile.class);
         pr = new PropertiesReader();
        pr.loadPropertiesFile();
        PropValue.MainConfig = pr.prop;
        PropValue.outputRecord = new LinkedList<>();

    }


    public unitTests() throws IOException {
        //no agrument constructor
    }

    @Test
    public void cardValidator(){
        CardChain chain = new CardChain();
        boolean isValid = chain.cardValidation("6011999999999999");
        System.out.println(isValid);

        isValid = chain.cardValidation("4120077000000");
        System.out.println(isValid);

        isValid = chain.cardValidation("5412125875412698");
        System.out.println(isValid);

        isValid = chain.cardValidation("4127777777777");
        System.out.println(isValid);

        isValid = chain.cardValidation("12343234534534543456");
        System.out.println(isValid);
    }

    @Test
    public void validFlight(){
        Flight = new validateFlight();
        Flight.validate(testRecord,data);
    }

    @Test
    public void invalidFlight(){
        InputFile testRecord = mapper.convertValue(bookingList.get(1), InputFile.class);
        Flight = new validateFlight();
        Flight.validate(testRecord,data);
    }

    @Test
    public void seatAvailable(){
        check = new seatAvailable();
        boolean valid = check.validate(testRecord,data);
        if (valid)
        check.updateSeat();
    }


    @Test
    public void totalPrice(){
        price = new Price();
        finalPrice= price.totalPrice(testRecord,data);
    }


    @Test
    public void writeToFile() throws IOException {
        String errorReason;
        CSVWrite writeTocsv = new CSVWrite();
        CSVWrite.ErrorReason error = new CSVWrite.ErrorReason();
        CSVtoJSON.Output outputTocsv = new CSVtoJSON.Output();
        Flight = new validateFlight();
        if (Flight.validate(testRecord, data)) {
            check = new seatAvailable();
            if (check.validate(testRecord, data)) {
                if (checkCreditCard(testRecord.getPaymentCardNumber())) {
                    price = new Price();
                    finalPrice = price.totalPrice(testRecord, data);
                    check.updateSeat();
                    outputTocsv.writeToFile(testRecord.getName(), testRecord.getFlightNumber(), testRecord.getSeatCategory(),
                            Integer.toString(testRecord.getNumberOfSeats()), Double.toString(finalPrice));
                } else {
                    errorReason = "Invalid Card, Please Re-enter the card number";
                    error.writeToFile(testRecord.getName(), testRecord.getFlightNumber(), errorReason,
                            Integer.toString(testRecord.getNumberOfSeats()), Double.toString(finalPrice));
                }
            }
                else{
                    errorReason = "No such seat exists";
                    error.writeToFile(testRecord.getName(), testRecord.getFlightNumber(), errorReason,
                            Integer.toString(testRecord.getNumberOfSeats()), Double.toString(finalPrice));
                }

        } else {
            errorReason = "Fight doesn't exist";
            error.writeToFile(testRecord.getName(), testRecord.getFlightNumber(), errorReason,
                    Integer.toString(testRecord.getNumberOfSeats()), Double.toString(finalPrice));
          }
            writeTocsv.addRecordToCSV(PropValue.outputRecord);
            writeTocsv.addRecordToErrorFile(PropValue.errorRecord);

        }

    private boolean checkCreditCard(String creditCardNumber){
        CardChain chainHandler = new CardChain();
        boolean validity = chainHandler.cardValidation(creditCardNumber);
        return validity;
    }



}
