package com.KoreaIT.java.AM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("��ɾ�) ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {
				System.out.printf("���� : ");
				String ����1 = sc.nextLine();

				System.out.printf("���� : ");
				String ����1 = sc.nextLine();

				System.out.println("1�� ���� �����Ǿ����ϴ�.");

				break;
			}
			if (cmd.length() == 0) {
				System.out.println("��ɾ �Է����ּ���.");
				continue;
			}
			if (cmd.equals("article list")) {
				System.out.println("�Խñ��� �����ϴ�.");
			} else {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
			}

		}

		while (true) {
			System.out.printf("��ɾ�) ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {
				System.out.printf("���� : ");
				String ����2 = sc.nextLine();

				System.out.printf("���� : ");
				String ����2 = sc.nextLine();

				System.out.println("2�� ���� �����Ǿ����ϴ�.");

				break;
			}
			if (cmd.length() == 0) {
				System.out.println("��ɾ �Է����ּ���.");
				continue;
			}
			if (cmd.equals("article list")) {
				System.out.println("�Խñ��� �����ϴ�.");
			} else {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
			}

		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}
}
