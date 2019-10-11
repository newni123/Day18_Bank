package com.iu.accountinfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.bankInput.AccountInfoInput;
import com.iu.bankView.AccountInfoView;
import com.iu.bankView.BankView;

public class AccountInfoController {
	private Scanner sc;
	private AccountInfoDAO accountInfoDAO;
	private AccountInfoView accountInfoView;
	private AccountInfoInput accountInfoInput;
	private BankView bankView;

	public AccountInfoController() {
		sc = new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInfoView = new AccountInfoView();
		accountInfoInput = new AccountInfoInput();
		bankView = new BankView();
	}

	public void start(String accountNumber) {
		boolean check = true;
		while (check) {
			System.out.println("1. 입출금 내역 조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 종료");
			System.out.print("작업 선택 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				try {
					ArrayList<AccountInfoDTO> accountInfoDTOs = new ArrayList<AccountInfoDTO>();
					accountInfoDTOs = accountInfoDAO.incomeselect(accountNumber);
					accountInfoView.view(accountInfoDTOs);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountInfoDAO.getAccountBalance(accountNumber);
					AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setIncomeKind(1);
					accountInfoDTO.setAccountNumber(accountNumber);
					accountInfoDTO.setIncome(income);
					accountInfoDTO.setAccountbalance(balance + income);
					select = accountInfoDAO.income(accountInfoDTO);
					if (select > 0) {
						select = accountInfoDAO.updateBalance(accountInfoDTO);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (select > 0)
					System.out.println("입금 완료");
				else
					System.out.println("입금 실패");
				break;
			case 3:
				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountInfoDAO.getAccountBalance(accountNumber);
					AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setIncomeKind(0);
					accountInfoDTO.setAccountNumber(accountNumber);
					accountInfoDTO.setIncome(income);
					accountInfoDTO.setAccountbalance(balance - income);
					select = accountInfoDAO.income(accountInfoDTO);
					if (select > 0) {
						select = accountInfoDAO.updateBalance(accountInfoDTO);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (select > 0)
					System.out.println("입금 완료");
				else
					System.out.println("입금 실패");
				break;
			default:
				check = !check;
				break;
			}
		}
	}
}
