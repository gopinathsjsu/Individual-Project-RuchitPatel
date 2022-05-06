package com.cmpe202.individualproject.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cmpe202.individualproject.handlers.CreditCardHandler;
import com.cmpe202.individualproject.handlers.MasterCard;
import com.cmpe202.individualproject.reader.*;
import com.cmpe202.individualproject.writer.CSVWriter;
import com.cmpe202.individualproject.writer.JSONWriter;
import com.cmpe202.individualproject.writer.Writer;
import com.cmpe202.individualproject.writer.XMLWriter;


public class App {
    public static String getFileType(String inputFile) {
        String extension = "";
        int i = inputFile.lastIndexOf('.');
        if (i > 0) {
            extension = inputFile.substring(i + 1);
        }
        return extension;
    }

    public static void main(String[] args) {
        String outputFile, inputFile;
        String inputFileType = "";
        String outputFileType = "";
        Reader filereader;
        Writer filewriter = null;
        List<CreditCardEntry> creditCardEntries = new ArrayList<>();
        List<OutputEntry> finalEntries = new ArrayList<>();
        if (args.length < 2) {
            throw new IllegalArgumentException("Please enter correct arguments");
        }
        inputFile = args[0];
        outputFile = args[1];
        inputFileType = inputFile.substring(inputFile.indexOf("."));
        outputFileType = outputFile.substring(outputFile.indexOf("."));

        if (!inputFileType.equals(outputFileType)) {
            System.out.println("Input and Output extensions are not same");
            System.exit(0);
        } else {
            System.out.println("Input and output extensions " + inputFileType + " and " + outputFileType + " are same");
        }
        String fileType = getFileType(inputFile);
        if (fileType.equalsIgnoreCase("csv")) {
            filereader = new CSVReader(new File(inputFile));
            filewriter = new CSVWriter();
            creditCardEntries = filereader.readFile(inputFile);
        } else if (fileType.equalsIgnoreCase("json")) {
            filereader = new JSONReader(new File(inputFile));
            filewriter = new JSONWriter();
            creditCardEntries = filereader.readFile(inputFile);
        } else if (fileType.equalsIgnoreCase("xml")) {
            filereader = new XMLReader(new File(inputFile));
            filewriter = new XMLWriter();
            creditCardEntries = filereader.readFile(inputFile);
        }

        //for loop on creditCardEntries
        //Traverse each creditcardentry and call master call handlers

        for (CreditCardEntry eachCreditCardEntry : creditCardEntries) {
            CreditCardHandler ccHandler = new MasterCard();
            String creditCardType = ccHandler.checkCreditCardType(eachCreditCardEntry);
            long ccNumber = eachCreditCardEntry.getCardNumber();
            finalEntries.add(new OutputEntry(ccNumber, creditCardType));
            filewriter.writeToFile(finalEntries, outputFile);
        }

    }

}
