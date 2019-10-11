package com.iu.bankView;

import java.util.List;
import com.iu.account.AccountDTO;

public class AccountView {
	public void View (List<AccountDTO> accountDTOs) {
		
		/*for (int i = 0; i < accountDTOs.size(); i++) {
			System.out.println("===================================================");
			System.out.println("계좌번호 : " + accountDTOs.get(i).getAccountNumber());
			System.out.println("계좌명 : " + accountDTOs.get(i).getAccountName());
			System.out.println("잔고 : " + accountDTOs.get(i).getAccountBalance());
		}
		System.out.println("===================================================");*/
		
		for (AccountDTO accountDTO : accountDTOs) {
			System.out.println("===========================");
			System.out.println("계좌번호 : " + accountDTO.getAccountNumber());
			System.out.println("계좌명 : " + accountDTO.getAccountName());
			System.out.println("잔고 : " + accountDTO.getAccountBalance());
		}
		System.out.println("===========================");
		
	}
}
