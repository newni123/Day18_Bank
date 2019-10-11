package test;

import java.util.List;
import java.util.Scanner;

import com.iu.accountinfo.AccountInfoDAO;
import com.iu.bankInput.AccountInput;
import com.iu.bankView.AccountView;
import com.iu.bankView.BankView;
import com.iu.member.MemberDTO;

public class AccountController {
/*	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountDTO accountDTO;
	private List<AccountDTO> accountDTOs;
	private AccountInput accountInput;
	private BankView bankView;
	private AccountView accountView;
	private AccountInfoDAO accountInfoDAO;

	public AccountController() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
		accountInput = new AccountInput();
		bankView = new BankView();
		accountView = new AccountView();
		accountInfoDAO = new AccountInfoDAO();
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
				try {
					
					accountDTOs = accountDAO.accountSelect(memberDTO);
					accountView.View(accountDTOs);
					System.out.print("계좌를 선택하세요 : ");
					int num = sc.nextInt();
					String myAcNum = accountDTOs.get(num - 1).getAccountNumber();
					System.out.print("받으실 분의 계좌번호를 입력하세요 : ");
					String yourAcNum = sc.next();
					String name = accountInfoDAO.AccountCheck(yourAcNum);
					System.out.println("예금주 : " + name);
					System.out.println("1. 확인");
					System.out.println("2. 취소");
					int choice = sc.nextInt();
					if (choice == 1) {
						System.out.print("입금하실 금액을 입력하세요 : ");
						int deposit = sc.nextInt();
						if (deposit <= accountDTOs.get(num - 1).getAccountBalance()) {
							int result = accountInfoDAO.income(deposit, yourAcNum, myAcNum);
							if (result > 0)
								System.out.println("입금 완료");
							else
								System.out.println("입금 실패");
						}
						else
							System.out.println("잔액 부족");
					} else
						break;
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

	}*/
}
