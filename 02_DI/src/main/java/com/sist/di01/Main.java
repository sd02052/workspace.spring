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
		 * - �������� ��ü�� �����ϰ� ������ ��ü�� ������ �ִ� ������ ������ ��.
		 * - ���⿡ �ִ� GenericXmlApplicationContext ��ü�� ������ �����
		 * 	  ������ Ŭ������.
		 * - �����⿡�� ������ ��ü�� �����̰�, �� ��ü�� ��� �����ϴ����� ���� ������ 
		 * 	  xml ���Ͽ� ������ �Ǿ� ����.
		 * - GenericXmlApplicationContext Ŭ������ �� xml ���Ͽ� ���ǵ�
		 * 	  ���� ������ �о� �ͼ� ��ü�� �����ϰ�, ������ ��ü�� ������ �ڿ� ����������
		 * 	  ������ ��.
		 * - xml�� �̿��� ������ ������ �ϴ� ���� �����̳ʰ� ������ ��ü�� �����ϱ� ����
		 * 	 <bean> �±׸� ����ϴ� ���� �� �� ����.
		 * - ������ �����̳ʰ� �����ؼ� �����ϴ� ��ü�� ������ ��(spring bean) ��ü��� 
		 * 	  �θ���, �Ϲ������� �ڹ� ��ü�� ������.
		 * - ������ �����̳ʴ� ������ �� ��ü�� <�̸�, �� ��ü> �̷��� ������ ������ ��.
		 * - ������ �����̳ʰ� �����ϰ� �ִ� ��ü�� ����ϰ� ���� ��� �� ��ü�� ����Ǿ� �ִ� 
		 * 	  �̸��� �̿��ؼ� ��ü�� �����ϰ� ��.
		 */
		
		/*
		 * ������ �����̳��� ����
		 * - BeanFactory : �ܼ��� ������ �����̳ʿ��� ��ü�� �����ϰ� DI�� ó���� �ִ�
		 * 					��ɸ��� ������ �ִ� ��ü.
		 * 					������ �������� ����ϴ� ������ �ܼ��� DI�� ����ϱ� ������ �ƴ�.
		 * 					�������� ����ϴ� �پ��� �ΰ� ���(Ʈ����� ó��, �ڹ� �ڵ� �����
		 * 					������ ����, �ֳ����̼��� �̿��� �� ����, �������� �̿���
		 * 					�� ���� ���) �����ε� �̷��� �ΰ����� ����� ����ϱ� ���ؼ��� 
		 * 					ApplicationContext ��ü�� �ַ� ����ϰ� ��.
		 * - AbstractApplicationContext : �����̳� ����(close)�� ���� ����� ������ �ִ� ��ü.
		 * - GenericXmlApplicationContext : AbstractApplicationContext ��ü��
		 *                                 ����� �޾Ƽ� ������� Ŭ�����μ� xml ���Ͽ���
		 *                                 ������ �� ���� ������ �о� ���� ������ ��. 
		 * - GenericXmlApplicationContext ��ü�� ������ �� �Ķ���� ������ 
		 *   "classpath:getsum.xml" �� �����ߴµ� �̴� Ŭ���� �н��� ��ġ�� xml ������
		 *   ���� ���Ϸ� ����Ѵٴ� �ǹ���.
		 * - GenericXmlApplicationContext ��ü�� ���޹��� xml ���Ͽ��� ���� ������ 
		 *   �о� �ͼ� ������ �� ��ü�� �����ϰ� ������Ƽ ���� ������ �� ��.
		 *   �̷��� ������ ������ �� ��ü�� getBean() �̶�� �޼��带 ����ؼ� ������ �� ����.
		 *   getBean() �޼����� ù��° �Ķ���ʹ� �����ϰ��� �ϴ� ������ �� ��ü�� ������ id
		 *   �̸��̸�, �ι�° �Ķ���ʹ� Ŭ���� Ÿ���� �ǹ���.
		 */
		
		/*
		 * - DI ��, ������ ��� �� �������� xml ������ ������ �Ǿ� ����.
		 * - ������ �����̳��� ctx�� "classpath:getsum.xml" ������ ����
		 * 	DI�� ������.
		 * - getsum.xml ������ resources ������ �� �־�� ��.
		 * 
		 * - AbstractApplicationContext ��ü�� DI �۾��� �� �ִ� ������ �����̳�.
		 * - ������ �����̳� ��ü�� �����ϰ� ��.
		 * - xml ������ �̿��Ͽ� �޸𸮷� ������ �����̳� ��ü�� ������ ��. (�޸𸮷� �ε�)
		 */
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:getsum.xml");
		
		/*
		 * - ���������� �� �ڵ忡�� ���� ������ �Ͼ�� �ȴ�.
		 * - new Ű���带 ������� �ʰ� ���� ������ �����̳ʿ��� ������ �����.
		 */
		// MyGetSum my = (MyGetSum) ctx.getBean("mySum");
		MyGetSum my = ctx.getBean("mySum",MyGetSum.class);
		
		
		my.sum();
		
		// ����� ������ �ݳ��� �ؾ� ��.
		ctx.close();
		
	}
}
