package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class VisaTest {
    @Test
    void checkValidVisa() {
        Long cardNumber = 4120000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Bob";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Visa visaObj = new Visa();
        String result = visaObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "Visa Card");
    }
    @Test
    void checkInvalidVisa() {
        Long cardNumber = 6011000000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Bob";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        Visa visaObj = new Visa();
        String result = visaObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "Visa Card");
    }

}