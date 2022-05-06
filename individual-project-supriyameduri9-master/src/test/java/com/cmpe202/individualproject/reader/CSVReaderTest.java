package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    void checkReadCsv() {
        String filePath = "/Users/supriyameduri/Documents/creditcard/src/test/java/sampleFiles/csv_input.csv";

        CSVReader csvReaderObj = new CSVReader(new File(filePath));
        List<CreditCardEntry> result = csvReaderObj.readFile(filePath);
        Long cardNumber = result.get(0).getCardNumber();
        String name = result.get(0).getNameOfCardholder();
        Assert.assertEquals((long) cardNumber, 5410000000000000L);
        Assert.assertEquals(name, "Alice");
        Assert.assertTrue(result.size() == 4);
    }
}