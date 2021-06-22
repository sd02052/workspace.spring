package com.test.nonspring03;

public class ServiceImpl {

	private DAO dao;

	// 기본 생성자
	public ServiceImpl() {
	}

	// 인자 생성자
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	// 비지니스 로직
	public void biz() {
		dao.add();
	}
}
