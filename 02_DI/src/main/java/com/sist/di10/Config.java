package com.sist.di10;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * DI ���� �� Java �ڵ忡�� �ֳ����̼��� �����Ͽ� 
 * �����ϴ� ���.
 * 
 * - ���� �� cglib ���̺귯���� �ݵ�� �ʿ���.
 * 		==> pom.xml ���Ͽ� ���̺귯���� �߰��� �־�� ��.
 * - @Configuration, @Bean �ֳ����̼��� �����.
 * 
 * - @Configuration : - Ŭ���� �տ� �����ϴ� �ֳ����̼�.
 *                    - "�ش� Ŭ������ ������ ������ ���Ǵ� Ŭ�����Դϴ�"
 *                      ��� �˷��ִ� �ֳ����̼�
 * - @Bean : �޼��� �տ� ���Ǵ� �ֳ����̼�.
 *           "�ش� �޼���� ��ü�� �����ϴµ� ���" �ȴٴ� �ǹ�.
 *           
 * - �ֳ����̼��� ����
 *  * �����Ϸ����� ������ �˷��ִ� ����.
 *  * ������ �� ���� ��ġ ���� �۾��� �����ϴ� ����.
 *  * ������ ���� ������ ó���� �ʿ��� ��� ���Ǵ� ����.
 */

@Configuration
public class Config {
	@Bean
	public Player player1() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("4�� Ÿ��");
		position.add("1���");

		Player player = new Player("�߽ż�", 38, position);

		player.setWeight(100);
		player.setHeight(188);

		return player;
	}

	@Bean
	public Player player2() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("9�� Ÿ��");
		position.add("����");

		Player player = new Player("������", 33, position);

		player.setWeight(120);
		player.setHeight(190);

		return player;
	}
}
