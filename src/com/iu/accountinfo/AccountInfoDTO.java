package com.iu.accountinfo;

import java.util.Date;

public class AccountInfoDTO {
	private int tradeNumber;
	private String accountNumber;
	private int income;
	private int accountbalance;
	private int incomKind;
	private Date date;

	public int getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}

	public int getIncomKind() {
		return incomKind;
	}

	public void setIncomKind(int incomKind) {
		this.incomKind = incomKind;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
