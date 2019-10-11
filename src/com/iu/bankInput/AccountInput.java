package com.iu.bankInput;

import java.util.Calendar;
import java.util.Scanner;

import com.iu.account.AccountDTO;

public class AccountInput {
	public AccountDTO accountCreate(Scanner sc) {
		AccountDTO accountDTO = new AccountDTO();
		System.out.print("계좌명 : ");
		accountDTO.setAccountName(sc.next());
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();
		accountDTO.setAccountNumber(String.valueOf(l));
		return accountDTO;
		
	}
}
