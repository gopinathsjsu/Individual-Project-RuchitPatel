
package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.CreditCardEntry;
import com.cmpe202.individualproject.main.OutputEntry;

import java.util.List;

public interface Writer {

    public void writeToFile(List<OutputEntry> result, String outputFile);
}

