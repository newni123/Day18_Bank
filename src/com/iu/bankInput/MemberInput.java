package com.iu.bankInput;

import java.util.Scanner;

import com.iu.member.MemberDTO;

public class MemberInput {
	
	public MemberDTO memberLogin(Scanner sc) {
		MemberDTO memberDTO = new MemberDTO();
		System.out.print("아이디 : ");
		memberDTO.setId(sc.next()); 
		System.out.print("비밀번호 : ");
		memberDTO.setPw(sc.next());
		return memberDTO;
	}
	public MemberDTO memberJoin(Scanner sc) {
		MemberDTO memberDTO = new MemberDTO();
		System.out.print("아이디 : ");
		memberDTO.setId(sc.next());
		System.out.print("비밀번호 : ");
		memberDTO.setPw(sc.next());
		System.out.print("이름 : ");
		memberDTO.setName(sc.next());
		System.out.print("전화번호 : ");
		memberDTO.setPhone(sc.next());
		System.out.print("이메일 : ");
		memberDTO.setEmail(sc.next());
		return memberDTO;
	}
}
