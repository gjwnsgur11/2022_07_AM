package com.KoreaIT.java.AM.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.dto.Article;
import com.KoreaIT.java.AM.util.Util;

public class ArticleController {

	private static List<Article> articles;
	private Scanner sc;

	public ArticleController(Scanner sc, List<Article> articles) {
		this.sc = sc;
		this.articles = articles;
	}

	int lastArticleId = 3;

	public void doWrite() {
		int id = lastArticleId + 1;
		lastArticleId = id;
		String regDate = Util.getDateStr();
		System.out.printf("���� : ");
		String title = sc.nextLine();
		System.out.printf("���� : ");
		String body = sc.nextLine();

		Article article = new Article(id, regDate, title, body);
		articles.add(article);

		System.out.printf("%d�� ���� �����Ǿ����ϴ�.\n", id);

	}

	public void showList() {
		if (articles.size() == 0) {
			System.out.println("�Խñ��� �����ϴ�");
			return;
		}
		System.out.println("��ȣ    |    ����    |    ��ȸ");
		for (int i = articles.size() - 1; i >= 0; i--) {
			Article article = articles.get(i);
			System.out.printf("%4d    |    %s    |    %d\n", article.id, article.title, article.hit);
		}

	}

	public void showDetail(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
			return;
		}

		foundArticle.increaseHit();

		System.out.printf("��ȣ : %d\n", foundArticle.id);
		System.out.printf("��¥ : %s\n", foundArticle.regDate);
		System.out.printf("���� : %s\n", foundArticle.title);
		System.out.printf("���� : %s\n", foundArticle.body);
		System.out.printf("��ȸ : %d\n", foundArticle.hit);

	}

	public void doModify(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
			return;
		}
		System.out.printf("�� ���� : ");
		String title = sc.nextLine();
		System.out.printf("�� ���� : ");
		String body = sc.nextLine();

		foundArticle.title = title;
		foundArticle.body = body;

		System.out.printf("%d�� ���� �����߽��ϴ�.\n", id);

	}

	public void doDelete(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);

		int foundIndex = getArticleIndexById(id);

		if (foundIndex == -1) {
			System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
			return;
		}

		articles.remove(foundIndex);
		System.out.printf("%d�� ���� �����߽��ϴ�.\n", id);

	}

	private static int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {

			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private static Article getArticleById(int id) {
		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	public void makeTestData() {
		System.out.println("�׽�Ʈ�� ���� �����͸� �����մϴ�.");

		articles.add(new Article(1, Util.getDateStr(), "����1", "����1", 10));
		articles.add(new Article(2, Util.getDateStr(), "����2", "����2", 20));
		articles.add(new Article(3, Util.getDateStr(), "����3", "����3", 30));
	}

}