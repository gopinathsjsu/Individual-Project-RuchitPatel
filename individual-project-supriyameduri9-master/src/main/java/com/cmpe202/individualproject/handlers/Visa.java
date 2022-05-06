package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;

public class Visa implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public Visa() {
        nextHandler = new Amex();
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {
        Long a = creditCardEntry.getCardNumber();
        String number = a.toString();
        String result = "";
        String fDigit = number.substring(0, 1);

        if (fDigit.equals("4") && (number.length() == 13 || number.length() == 16)) {
            result = "Visa Card";
        } else {
            return nextHandler.checkCreditCardType(creditCardEntry);
        }
        return result;
    }
}

