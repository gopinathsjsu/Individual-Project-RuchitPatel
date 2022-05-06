package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONWriterTest {

    @Test
    void checkJSONWrite() {
        Long cardNumber = 5410000000000000L;
        String cardType = "Master Card";
        JSONWriter jsonWriterObj = new JSONWriter();
        List<OutputEntry> result = new ArrayList<>();
        result.add(new OutputEntry(cardNumber, cardType));
        // OutputEntry result = new OutputEntry(cardNumber,cardType);
        String path = "src/test/java/sampleFiles/json_output.json";
        jsonWriterObj.writeToFile(result, path);
        File file = new File(path);

        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals((long) cardNumber, 5410000000000000L);
        Assert.assertEquals(cardType, "Master Card");

    }
}