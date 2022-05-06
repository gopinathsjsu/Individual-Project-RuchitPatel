package com.cmpe202.individualproject.main;

public class OutputEntry {
    Long cardNumber;
    String type;

    public OutputEntry() {
    }

    public OutputEntry(Long cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
