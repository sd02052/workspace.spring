package com.sist.aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.aop03.Person;

public class Main {
	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop03.xml");

		Person boy = (Person) ctx.getBean("boy");
		boy.doSomething();

		ctx.close();

		System.out.println("==============================================");

		Person girl = (Person) ctx.getBean("girl");
		girl.doSomething();

		ctx.close();
	}
}
