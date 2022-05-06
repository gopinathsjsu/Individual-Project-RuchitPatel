package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MasterCardTest {
    @Test
    void checkValidMasterCard() {
        Long cardNumber = 5410000000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Alice";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "Master Card");
    }

    @Test
    void checkInvalidMasterCard() {
        Long cardNumber = 6011000000000000L;
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Alice";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, expDate, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "Master Card");
    }

}