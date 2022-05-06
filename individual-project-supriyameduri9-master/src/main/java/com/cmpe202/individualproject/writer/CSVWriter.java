package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.handlers.CreditCardHandler;
import com.cmpe202.individualproject.handlers.MasterCard;
import com.cmpe202.individualproject.main.CreditCardEntry;
import com.cmpe202.individualproject.main.OutputEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter implements Writer {

    File outputFile;

    public CSVWriter() {
    }

    @Override
    public void writeToFile(List<OutputEntry> result, String outputFile) {
        FileWriter fileWriter = null;
        String File_header = "CardNumber,CardType";
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.append(File_header.toString());
            fileWriter.append('\n');
            for (OutputEntry each : result) {
                fileWriter.append(each.getCardNumber().toString());
                fileWriter.append(',');
                fileWriter.append(each.getType());
                fileWriter.append('\n');
                fileWriter.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
