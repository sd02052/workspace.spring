package com.sist.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		// 스프링 컨테이너 객체를 생성을 함.
		// xml 설정 파일을 읽어들여서 메모리로 로딩이 됨.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:exam.xml");

		ExamDAO dao = (ExamDAO) ctx.getBean("daoImpl");
		dao.printMsg();

		// 사용된 자원을 반납
		ctx.close();
	}
}
