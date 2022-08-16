package com.KoreaIT.java.AM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.AM.util.Util;

public class MemberController {

	private static List<Member> members;
	private Scanner sc;

	public MemberController(Scanner sc, List<Member> members) {
		this.sc = sc;
		this.members = members;
	}

	int lastMemberId = 0;

	public void doJoin(List<Member> members, Scanner sc) {
		String loginId = null;
		String loginPw = null;
		String loginPwC = null;

		int id = lastMemberId + 1;
		lastMemberId = id;
		String regDate = Util.getDateStr();
		while (true) {
			System.out.printf("���̵� : ");
			loginId = sc.nextLine();

			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s ��(��) �̹� ������� ���̵��Դϴ�\n", loginId);
				continue;
			}

			break;
		}

		while (true) {
			System.out.printf("��й�ȣ : ");
			loginPw = sc.nextLine();
			System.out.printf("��й�ȣ Ȯ��: ");
			loginPwC = sc.nextLine();

			if (loginPw.equals(loginPwC) == false) {
				System.out.println("��й�ȣ�� �ٽ� �Է����ּ���");
				continue;
			}
			break;
		}

		System.out.printf("�̸� : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		members.add(member);

		System.out.printf("%d�� ȸ���� �����Ǿ����ϴ�.\n", id);

	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for (Member member : members) {

			if (member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}

}