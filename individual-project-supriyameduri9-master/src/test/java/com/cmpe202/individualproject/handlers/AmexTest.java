package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

class AmexTest {

    @Test
    void checkValidAmex() {
        Long cardNumber = 341000000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Amex amexObj = new Amex();
        String result = amexObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "American Express Card");
    }

    @Test
    void checkInvalidAmex() {
        Long cardNumber = 6011000000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Amex amexObj = new Amex();
        String result = amexObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "American Express Card");
    }

}