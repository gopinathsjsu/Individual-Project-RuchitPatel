package com.cmpe202.individualproject.main;


import java.time.LocalDate;
import java.util.Date;

public class CreditCardEntry {
	
	Long cardNumber;
	LocalDate expirationDate;
	String nameOfCardholder;

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getNameOfCardholder() {
		return nameOfCardholder;
	}

	public void setNameOfCardholder(String nameOfCardholder) {
		this.nameOfCardholder = nameOfCardholder;
	}



	public CreditCardEntry(Long cardNumber, LocalDate expirationDate, String nameOfCardholder) {
		// TODO Auto-generated constructor stub
		this.cardNumber = cardNumber;
		this.expirationDate =  expirationDate;
		this.nameOfCardholder = nameOfCardholder;
	}
	public CreditCardEntry(long cardNumber, LocalDate parse, String nameOfCardholder){

	}
	

}
