package ReaderWriter;



import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import test.PropValue;

import java.io.*;
import java.util.*;


public class CSVtoJSON {
    public static  List<Map<?,?>> readCsvToJson(String csvFile){
        File read = new File(csvFile);
        //this list hold each record in CSV file as a key value pair with header as key and value as values.
        List<Map<?,?>> flights = new ArrayList<>();
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?,?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(read);
            System.out.println();
            while(mappingIterator.hasNext()){
                flights.add(mappingIterator.next());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return flights;
    }


    public static class Output implements Writer {

        @Override
        public void writeToFile(String bookingName ,
                                 String flightNumber , String category , String numberOfSeats ,String finalPrice ) {

            String[] record = {bookingName ,flightNumber, category, numberOfSeats, finalPrice};
            PropValue.outputRecord.add(record);
        }


        }
}
