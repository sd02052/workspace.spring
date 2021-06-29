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

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private JdbcTemplate template;
	String sql = null;

	@Override
	public List<BoardDTO> getBoardList(int startNo, int endNo) {
		List<BoardDTO> list = null;
		sql = "select * from " + "(select row_number() over(order by board_no desc) rnum, b.* from board b)"
				+ "where rnum >= ? and rnum <= ?";

		list = this.template.query(sql, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));

				return dto;
			}
		}, startNo, endNo);
		return list;
	}

	@Override
	public int insertBoard(final BoardDTO dto) {

		sql = "select count(*) from board";
		final int count = this.template.queryForInt(sql) + 1;

		sql = "insert into board values(?,?,?,?,?,default,sysdate)";
		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count);
				ps.setString(2, dto.getBoard_writer());
				ps.setString(3, dto.getBoard_title());
				ps.setString(4, dto.getBoard_cont());
				ps.setString(5, dto.getBoard_pwd());
			}
		});
	}

	@Override
	public BoardDTO getBoardCont(int board_no) {

		sql = "select * from board where board_no = ?";
		return this.template.queryForObject(sql, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();

				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));

				return dto;
			}
		}, board_no);
	}

	@Override
	public int updateBoard(final BoardDTO dto) {

		sql = "update board set board_title = ?, board_cont = ? where board_no = ?";
		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getBoard_title());
				ps.setString(2, dto.getBoard_cont());
				ps.setInt(3, dto.getBoard_no());
			}
		});
	}

	@Override
	public int deleteBoard(int board_no) {

		sql = "delete from board where board_no = ?";
		return this.template.update(sql, board_no);
	}

	@Override
	public void updateBoardNo(int board_no) {

		sql = "update board set board_no = board_no - 1 where board_no > ?";
		this.template.update(sql, board_no);
	}

	@Override
	public List<BoardDTO> searchBoardList(String field, String keyword) {
		List<BoardDTO> list = null;

		if (field.equals("title")) {
			sql = "select * from board where board_title like ? order by board_no desc";
			list = this.template.query(sql, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();

					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_regdate(rs.getString("board_regdate"));

					return dto;
				}
			}, "%" + keyword + "%");
		} else if (field.equals("cont")) {
			sql = "select * from board where board_cont like ? order by board_no desc";
			list = this.template.query(sql, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();

					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_regdate(rs.getString("board_regdate"));

					return dto;
				}
			}, "%" + keyword + "%");
		} else if (field.equals("title_cont")) {
			sql = "select * from board where board_title like ? or board_cont like ? order by board_no desc";
			list = this.template.query(sql, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();

					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_regdate(rs.getString("board_regdate"));

					return dto;
				}
			}, "%" + keyword + "%", "%" + keyword + "%");
		} else {
			sql = "select * from board where board_writer like ? order by board_no desc";
			list = this.template.query(sql, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();

					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_regdate(rs.getString("board_regdate"));

					return dto;
				}
			}, "%" + keyword + "%");
		}
		return list;
	}

	@Override
	public void hitBoard(int board_no) {
		sql = "update board set board_hit = board_hit + 1 where board_no = ?";
		this.template.update(sql, board_no);
	}

	@Override
	public int getListCount() {

		sql = "select count(*) from board";
		int count = this.template.queryForInt(sql);
		return count;
	}

}
