package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DiscoverTest {

    @Test
    void checkValidDiscover() {
        Long cardNumber = 6011000000000000L;
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assert.assertEquals(result, "Discover Card");
    }
    @Test
    void checkInvalidDiscover() {
        Long cardNumber = 341000000000000L;
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "Discover Card");
    }
}