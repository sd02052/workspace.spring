package com.sist.di03;

public class ServiceImpl {

	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) { // OracleDAO, MysqlDAO �Ѵ� �� �� �ִ�.(������)
		this.dao = dao;
	}

	// �����Ͻ� ����
	public void biz() {
		dao.add();
	}

}