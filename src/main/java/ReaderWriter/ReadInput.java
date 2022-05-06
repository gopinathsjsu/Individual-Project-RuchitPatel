package ReaderWriter;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadInput {


    public ReadInput() {
        //No argument constructor
    }

    public List<Map<?, ?>> convertCsv(String csvFile) throws IOException {

        File read = new File(csvFile);
        List<Map<?,?>> input = new ArrayList<>();
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?,?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(read);
            System.out.println();
            while(mappingIterator.hasNext()){
                input.add(mappingIterator.next());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(input);
        return input;
   }



}
