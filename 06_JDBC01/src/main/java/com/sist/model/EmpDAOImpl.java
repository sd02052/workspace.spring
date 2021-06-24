package com.sist.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository // Spring에서 일반적으로 DAO 클래스에 적용되는 애노테이션
// DB에 접근하는 클래스에 사용
public class EmpDAOImpl implements EmpDAO {

	// 자동으로 의존관계가 설정된는 애노테이션
	// 무조건 객체에 대한 의존을 주입시키는 애노테이션
	@Autowired
	private JdbcTemplate template;

	String sql = null;

	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> list = null;

		sql = "select * from emp order by empno";
		return list = template.query(sql, new RowMapper<EmpDTO>() { // query() : 쿼리 결과값이 여러개인것에 사용
			// queryForObject() : 쿼리 결과가 하나만 나오는 경우

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getDouble("sal"));
				dto.setComm(rs.getDouble("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				return dto;
			}
		});
	}

	@Override
	public int empInsert(final EmpDTO dto) {
		sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getEmpno());
				ps.setString(2, dto.getEname());
				ps.setString(3, dto.getJob());
				ps.setInt(4, dto.getMgr());
				ps.setDouble(5, dto.getSal());
				ps.setDouble(6, dto.getComm());
				ps.setInt(7, dto.getDeptno());
			}
		});
	}

	@Override
	public EmpDTO empCont(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int empUpdate(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int empDelete(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DeptDTO> getDeptList() {
		List<DeptDTO> deptList = null;

		sql = "select * from dept order by deptno";
		return deptList = this.template.query(sql, new RowMapper<DeptDTO>() {

			@Override
			public DeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				DeptDTO dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
	}

	@Override
	public List<EmpDTO> getMgrList() {
		List<EmpDTO> mgrList = null;

		sql = "select * from emp where job = 'MANAGER' order by empno";

		return mgrList = this.template.query(sql, new RowMapper<EmpDTO>() {

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				return dto;
			}
		});
	}

}
