package com.iu.bankView;

import java.util.ArrayList;

import com.iu.accountinfo.AccountInfoDTO;

public class AccountInfoView {
	public void view (ArrayList<AccountInfoDTO> accountInfoDTOs) {
		System.out.println("TradeNumber\tIncome\tBalance\tKind\tTradeDate");
		for(AccountInfoDTO accountInfoDTO : accountInfoDTOs) {
			System.out.print("\t"+accountInfoDTO.getTradeNumber()+"\t");
			System.out.print(accountInfoDTO.getIncome()+"\t");
			System.out.print(accountInfoDTO.getAccountbalance()+"\t");
			System.out.print(accountInfoDTO.getIncomeKind()+"\t");
			System.out.print(accountInfoDTO.getTradedate()+"\t");
			System.out.println();
		}
	}
}
