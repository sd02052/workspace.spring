package com.sist.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		// ������ �����̳� ��ü�� ������ ��.
		// xml ���� ������ �о�鿩�� �޸𸮷� �ε��� ��.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:exam.xml");

		ExamDAO dao = (ExamDAO) ctx.getBean("daoImpl");
		dao.printMsg();

		// ���� �ڿ��� �ݳ�
		ctx.close();
	}
}
