package com.iu.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.accountinfo.AccountInfoController;
import com.iu.accountinfo.AccountInfoDAO;
import com.iu.bankInput.AccountInput;
import com.iu.bankView.AccountView;
import com.iu.bankView.BankView;
import com.iu.member.MemberDTO;

public class AccountController {
	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountDTO accountDTO;
	private List<AccountDTO> accountDTOs;
	private AccountInput accountInput;
	private BankView bankView;
	private AccountView accountView;
	private AccountInfoController accountInfoController;

	public AccountController() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
		accountInput = new AccountInput();
		bankView = new BankView();
		accountView = new AccountView();
		accountInfoController = new AccountInfoController();
		// accountDTO = null;
		// accountDTOs = null;
	}

	public void start(MemberDTO memberDTO) {
		int select = 0;
		boolean check = true;
		while (check) {
			System.out.println("1. 계좌 개설");
			System.out.println("2. 계좌 조회");
			System.out.println("3. 은행 업무");
			System.out.println("4. 종료 ");
			System.out.print("작업 선택 : ");

			select = sc.nextInt();

			switch (select) {
			case 1:
				accountDTO = accountInput.accountCreate(sc);
				accountDTO.setId(memberDTO.getId());
				try {
					select = accountDAO.accountCreate(accountDTO);
				} catch (Exception e) {
					select = 0;
				}
				String str = "Create Fail";
				if (select > 0)
					str = "create Success";
				bankView.view(str);
				break;

			case 2:
				accountDTO = new AccountDTO();
				try {
					accountDTOs = accountDAO.accountSelect(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (accountDTOs.size() == 0)
					System.out.println("만들어진 계좌가 없습니다.");
				else {
					accountView.View(accountDTOs);
				}
				break;
			case 3:

				accountDTO = new AccountDTO();
				try {
					accountDTOs = accountDAO.accountSelect(memberDTO);
					if (accountDTOs.size() == 0)
						System.out.println("만들어진 계좌가 없습니다.");
					else {
						accountView.View(accountDTOs);
						System.out.print("계좌 선택 : ");
						int choice = sc.nextInt();
						accountInfoController.start(accountDTOs.get(choice - 1).getAccountNumber());
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			default:
				check = !check;
				break;
			}
		}

	}
}
