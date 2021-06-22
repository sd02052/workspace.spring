package com.sist.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		GetSum getSum = new GetSum();
		MyGetSum myGetSum = new MyGetSum();
		myGetSum.setSu1(200);
		myGetSum.setSu2(100);
		myGetSum.setGetSum(getSum);
		myGetSum.sum();
		*/
		
		/*
		 * - 스프링은 객체를 생성하고 각각의 객체를 연결해 주는 조립기 역할을 함.
		 * - 여기에 있는 GenericXmlApplicationContext 객체가 조립기 기능을
		 * 	  구현한 클래스임.
		 * - 조립기에서 생성할 객체가 무엇이고, 각 객체를 어떻게 연결하는지에 대한 정보는 
		 * 	  xml 파일에 설정이 되어 있음.
		 * - GenericXmlApplicationContext 클래스는 이 xml 파일에 정의된
		 * 	  설정 정보를 읽어 와서 객체를 생성하고, 각각의 객체를 연결한 뒤에 내부적으로
		 * 	  보관을 함.
		 * - xml을 이용한 스프링 설정을 하다 보면 컨테이너가 생성할 객체를 지정하기 위해
		 * 	 <bean> 태그를 사용하는 것을 볼 수 있음.
		 * - 스프링 컨테이너가 생성해서 보관하는 객체를 스프링 빈(spring bean) 객체라고 
		 * 	  부르며, 일반적으로 자바 객체와 동일함.
		 * - 스프링 컨테이너는 생성한 빈 객체를 <이름, 빈 객체> 이렇게 쌍으로 보관을 함.
		 * - 스프링 컨테이너가 보관하고 있는 객체를 사용하고 싶은 경우 빈 객체와 연결되어 있는 
		 * 	  이름을 이용해서 객체를 참조하게 됨.
		 */
		
		/*
		 * 스프링 컨테이너의 종류
		 * - BeanFactory : 단순히 스프링 컨테이너에서 객체를 생성하고 DI만 처리해 주는
		 * 					기능만을 제공해 주는 객체.
		 * 					하지만 스프링을 사용하는 이유는 단순히 DI만 사용하기 위함이 아님.
		 * 					스프링을 사용하는 다양한 부가 기능(트랜잭션 처리, 자바 코드 기반의
		 * 					스프링 설정, 애노테이션을 이용한 빈 설정, 스프링을 이용한
		 * 					웹 개발 등등) 때문인데 이러한 부가적인 기능을 사용하기 위해서는 
		 * 					ApplicationContext 객체를 주로 사용하게 됨.
		 * - AbstractApplicationContext : 컨테이너 종료(close)와 같은 기능을 제공해 주는 객체.
		 * - GenericXmlApplicationContext : AbstractApplicationContext 객체를
		 *                                 상속을 받아서 만들어진 클래스로서 xml 파일에서
		 *                                 스프링 빈 설정 정보를 읽어 오는 역할을 함. 
		 * - GenericXmlApplicationContext 객체를 생성할 때 파라미터 값으로 
		 *   "classpath:getsum.xml" 을 전달했는데 이는 클래스 패스에 위치한 xml 파일을
		 *   설정 파일로 사용한다는 의미임.
		 * - GenericXmlApplicationContext 객체는 전달받은 xml 파일에서 설정 정보를 
		 *   읽어 와서 스프링 빈 객체를 생성하고 프로퍼티 값을 설정을 해 줌.
		 *   이렇게 생성된 스프링 빈 객체는 getBean() 이라는 메서드를 사용해서 구현할 수 있음.
		 *   getBean() 메서드의 첫번째 파라미터는 구현하고자 하는 스프링 빈 객체의 고유한 id
		 *   이름이며, 두번째 파라미터는 클래스 타입을 의미함.
		 */
		
		/*
		 * - DI 즉, 주입을 어떻게 할 것인지는 xml 문서에 기입이 되어 있음.
		 * - 스프링 컨테이너인 ctx가 "classpath:getsum.xml" 파일을 보고
		 * 	DI를 진행함.
		 * - getsum.xml 파일은 resources 폴더에 들어가 있어야 함.
		 * 
		 * - AbstractApplicationContext 객체가 DI 작업을 해 주는 스프링 컨테이너.
		 * - 스프링 컨테이너 객체를 생성하게 됨.
		 * - xml 파일을 이용하여 메모리로 스프링 컨테이너 객체가 생성이 됨. (메모리로 로딩)
		 */
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:getsum.xml");
		
		/*
		 * - 실제적으로 이 코드에서 주입 과정이 일어나게 된다.
		 * - new 키워드를 사용하지 않고 직접 스프링 컨테이너에서 꺼내서 사용함.
		 */
		// MyGetSum my = (MyGetSum) ctx.getBean("mySum");
		MyGetSum my = ctx.getBean("mySum",MyGetSum.class);
		
		
		my.sum();
		
		// 사용을 했으면 반납을 해야 함.
		ctx.close();
		
	}
}
