package com.iu.bankInput;

import java.util.Scanner;

public class AccountInfoInput {
	public long incomeInput(Scanner sc) {
		/*System.out.print("받으시는 분의 계좌 번호를 입력하세요 : ");
		String yourAcNum = sc.next();*/
		System.out.print("금액을 입력하세요 : ");
		long deposit = sc.nextInt();
		return deposit;
	}
}
