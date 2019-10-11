package com.iu.member;

import java.util.Scanner;

import com.iu.account.AccountController;
import com.iu.bankInput.MemberInput;
import com.iu.bankView.BankView;

public class MemberController {
	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberDTO memberDTO;
	private MemberInput memberInput;
	private BankView bankView;
	private AccountController accountController;
	public MemberController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberInput = new MemberInput();
		bankView = new BankView();
		accountController = new AccountController();
	}

	public void start() {
		boolean check = true;
		while (check) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 프로그램 종료");
			System.out.print("작업을 선택하세요 : ");
			int select = sc.nextInt();
			memberDTO = null;
			switch (select) {
			case 1:
				memberDTO = memberInput.memberLogin(sc);
				try {
					memberDTO = memberDAO.memberLogin(memberDTO);
					if (memberDTO != null) {
						System.out.println(memberDTO.getName() + "님 로그인");
						System.out.println();
						accountController.start(memberDTO);
					}
					else
						bankView.view("로그인 실패");
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}

			case 2:
				memberDTO = memberInput.memberJoin(sc);
				try {
					select = memberDAO.memberJoin(memberDTO);
				} catch (Exception e) {
					select = 0;
				}
				String msg = "Member Join Fail";
				if (select > 0)
					msg = "Member Join Success";
				bankView.view(msg);
				break;
			default:
				System.out.println("프로그램을 종료합니다.");
				check = !check;
				break;
			}
		}
	}
}
