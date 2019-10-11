package com.iu.accountinfo;

import java.util.Date;

public class AccountInfoDTO {
	private long tradeNumber;
	private String accountNumber;
	private long income;
	private long accountbalance;
	private int incomeKind;
	private Date tradedate;

	public long getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(long l) {
		this.tradeNumber = l;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(long balance) {
		this.accountbalance = balance;
	}

	public int getIncomeKind() {
		return incomeKind;
	}

	public void setIncomeKind(int incomKind) {
		this.incomeKind = incomKind;
	}

	public Date getTradedate() {
		return tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	

}
