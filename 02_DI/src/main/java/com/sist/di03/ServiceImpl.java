package com.sist.di03;

public class ServiceImpl {

	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) { // OracleDAO, MysqlDAO 둘다 올 수 있다.(다형성)
		this.dao = dao;
	}

	// 비지니스 로직
	public void biz() {
		dao.add();
	}

}
