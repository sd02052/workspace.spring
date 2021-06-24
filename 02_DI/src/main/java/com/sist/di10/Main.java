package com.sist.di10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:baseball3.xml");

		Player player1 = (Player) ctx.getBean("player1");
		System.out.println("이름 : " + player1.getName());
		System.out.println("나이 : " + player1.getAge());
		System.out.println("포지션 : " + player1.getPosition());
		System.out.println("체중 : " + player1.getWeight());
		System.out.println("키 : " + player1.getHeight());
		System.out.println("===================================================");

		Player player2 = (Player) ctx.getBean("player2");
		System.out.println("이름 : " + player2.getName());
		System.out.println("나이 : " + player2.getAge());
		System.out.println("포지션 : " + player2.getPosition());
		System.out.println("체중 : " + player2.getWeight());
		System.out.println("키 : " + player2.getHeight());
		System.out.println("===================================================");

		Player player3 = (Player) ctx.getBean("player3");
		System.out.println("이름 : " + player3.getName());
		System.out.println("나이 : " + player3.getAge());
		System.out.println("포지션 : " + player3.getPosition());
		System.out.println("체중 : " + player3.getWeight());
		System.out.println("키 : " + player3.getHeight());
		System.out.println("===================================================");
		ctx.close();
	}
}
