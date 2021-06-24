package com.sist.di03;

public class MysqlDAO implements DAO {

	public MysqlDAO() {
		System.out.println("MysqlDAO 생성자!");
	}

	@Override
	public void add() {
		System.out.println("MysqlDAO 수행@@@@@");
	}

}
