package com.sist.di03;

public class MysqlDAO implements DAO {

	public MysqlDAO() {
		System.out.println("MysqlDAO ������!");
	}

	@Override
	public void add() {
		System.out.println("MysqlDAO ����@@@@@");
	}

}
