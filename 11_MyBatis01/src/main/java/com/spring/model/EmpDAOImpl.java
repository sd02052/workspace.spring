package com.spring.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EmpDTO> getEmpList() {

		return this.sqlSession.selectList("allList");

	}

	@Override
	public List<DeptDTO> getDeptList() {

		return this.sqlSession.selectList("deptList");
	}

	@Override
	public List<EmpDTO> getMgrList() {

		return this.sqlSession.selectList("mgrList");
	}

	@Override
	public int insertEmp(EmpDTO dto) {

		return this.sqlSession.insert("add", dto);
	}

	@Override
	public EmpDTO getCont(int empno) {

		return this.sqlSession.selectOne("cont", empno);
	}

	@Override
	public int updateEmp(EmpDTO dto) {

		return this.sqlSession.update("update", dto);
	}

	@Override
	public int deleteEmp(int empno) {

		return this.sqlSession.delete("delete", empno);
	}

}
