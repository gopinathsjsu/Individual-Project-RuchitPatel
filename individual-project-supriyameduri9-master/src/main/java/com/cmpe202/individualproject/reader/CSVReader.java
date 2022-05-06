package com.cmpe202.individualproject.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.cmpe202.individualproject.main.CreditCardEntry;

public class CSVReader implements Reader {

    File file;

    public CSVReader() {
    }

    public CSVReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {

        BufferedReader br;
        List<CreditCardEntry> result = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/dd/yy");

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            line = br.readLine();
            if (line == null) throw new IllegalArgumentException("File is empty");
            while ((line = br.readLine()) != null) {
                String[] entries = line.split(",");
                if (entries.length > 4) throw new ArrayIndexOutOfBoundsException();
                Long cardNumber = Long.parseLong(entries[0]);

                String dateEntry = entries[1];
                LocalDate edate = LocalDate.parse(dateEntry, df);

                String nameOfCardHolder = entries[2];

                CreditCardEntry ccEntry = new CreditCardEntry(cardNumber, edate, nameOfCardHolder);
                result.add(ccEntry);
            }
            br.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

