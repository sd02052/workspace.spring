package com.test.nonspring03;

public class MySqlDAO implements DAO {

	public MySqlDAO() {
		System.out.println("MySqlDAO 생성자 입니다.");
	}

	@Override
	public void add() {
		System.out.println("MySqlDAO 입니다...");
	}

}
