package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JSONReader implements Reader {
    File file;

    public JSONReader() {
    }

    public JSONReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {
        FileReader fr;
        List<CreditCardEntry> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
//        String jsonFile = file.getAbsolutePath();
        List<String> cardDetails;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date expDate = new Date();
        try {
            fr = new FileReader(file);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);

            //JSONObject jsonObject = (JSONObject) obj;
            JSONArray cards = (JSONArray) obj;


            for (int i = 0; i < cards.size(); i++) {
                cardDetails = new ArrayList<>();
                String entries = cards.get(i).toString();
                String[] eachCardEntry = entries.split(",");
                for (String each : eachCardEntry) {
                    String[] split1 = each.split(":");
                    String replace1 = split1[1].replaceAll("}", "");
                    String replace2 = replace1.replaceAll("\\\\", "");
                    cardDetails.add(replace2);
                }
                String a = cardDetails.get(0);
                String b = cardDetails.get(1).replaceAll("\"", "");
                String name = cardDetails.get(2).replaceAll("\"", "");

                Long cNumber = Long.parseLong(a);

                DateTimeFormatter df = DateTimeFormatter.ofPattern("M/dd/yyyy");
                LocalDate eDate = LocalDate.parse(b, df);

                result.add(new CreditCardEntry(cNumber, eDate, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
