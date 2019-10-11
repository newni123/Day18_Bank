package test;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.bankView.AccountInfoView;
/*
public class AccountInfoController {
	private Scanner sc;
	private AccountInfoDAO accountInfoDAO;
	private AccountInfoView accountInfoView;
	private AccountInfoDTO accountInfoDTO;

	public AccountInfoController() {
		sc = new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInfoView = new AccountInfoView();
		accountInfoDTO = new AccountInfoDTO();
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
				int result = 0;
				System.out.print("받으시는 분의 계좌 번호를 입력하세요 : ");
				String yourAcNum = sc.next();
				System.out.print("입금 하려는 금액을 입력하세요 : ");
				int deposit = sc.nextInt();
				try {
					result = accountInfoDAO.deposit(deposit, yourAcNum, accountNumber);
					int r
					accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setAccountNumber(yourAcNum);
					accountInfoDTO.setIncome(deposit);
					accountInfoDTO.setAccountbalance(accountInfoDTO.getAccountbalance()+deposit);
					accountInfoDTO.setIncomeKind(1);
					accountInfoDAO.income(accountInfoDTO);
					
					accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setAccountNumber(accountNumber);
					accountInfoDTO.setIncome(deposit);
					accountInfoDTO.setAccountbalance(accountInfoDTO.getAccountbalance()-deposit);
					accountInfoDTO.setIncomeKind(0);
					accountInfoDAO.income(accountInfoDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (result > 0)
					System.out.println("입금 완료");
					break;
			case 3:

				break;
			default:
				check = !check;
				break;
			}
		}
	}
}*/
