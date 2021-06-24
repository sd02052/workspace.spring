﻿package com.test.nonspring03;

public class Main {
	public static void main(String[] args) {

		// 기존에 Java, JSP에서 사용하던 방식
		MySqlDAO mySqlDAO = new MySqlDAO();
		mySqlDAO.add();

		OracleDAO oracleDAO = new OracleDAO();
		oracleDAO.add();

		System.out.println("========================");

		// 1. 생성자를 이용하여 주입하는 방법
		ServiceImpl impl1 = new ServiceImpl(new MySqlDAO());
		impl1.biz();

		// 2. setter() 메서드를 이용하여 주입하는 방법.
		ServiceImpl impl2 = new ServiceImpl();
		impl2.setDao(new OracleDAO());
		impl2.biz();
	}
}
