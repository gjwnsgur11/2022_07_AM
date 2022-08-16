package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.controller.ArticleController;
import com.KoreaIT.java.AM.controller.MemberController;
import com.KoreaIT.java.AM.dto.Article;
import com.KoreaIT.java.AM.dto.Member;

public class App {

	private static List<Article> articles;
	private static List<Member> members;

	public App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void run() {
		System.out.println("==���α׷� ����==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc, members);
		ArticleController articleController = new ArticleController(sc, articles);

		articleController.makeTestData();

		while (true) {
			System.out.printf("��ɾ�) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("��ɾ �Է����ּ���");
				continue;
			}
			if (cmd.equals("member join")) {
				memberController.doJoin();
			} else if (cmd.equals("article write")) {
				articleController.doWrite();
			} else if (cmd.equals("article list")) {
				articleController.showList();
			} else if (cmd.startsWith("article detail ")) {
				articleController.showDetail(cmd);
			} else if (cmd.startsWith("article modify ")) {
				articleController.doModify(cmd);
			} else if (cmd.startsWith("article delete ")) {
				articleController.doDelete(cmd);
			} else {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�");
			}

		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}

}