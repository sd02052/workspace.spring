package com.test.nonspring03;

public class MySqlDAO implements DAO {

	public MySqlDAO() {
		System.out.println("MySqlDAO ������ �Դϴ�.");
	}

	@Override
	public void add() {
		System.out.println("MySqlDAO �Դϴ�...");
	}

}
