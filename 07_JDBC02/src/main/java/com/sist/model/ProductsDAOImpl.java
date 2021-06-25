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
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private JdbcTemplate template;
	String sql = null;

	@Override
	public List<ProductsDTO> getProductList() {
		List<ProductsDTO> list = null;

		sql = "select * from products order by pnum desc";
		return list = this.template.query(sql, new RowMapper<ProductsDTO>() {

			@Override
			public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductsDTO dto = new ProductsDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProducts_name(rs.getString("products_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				return dto;
			}
		});
	}

	@Override
	public int insertProduct(final ProductsDTO dto) {

		sql = "select count(*) from products";
		final int count = this.template.queryForInt(sql) + 1;

		sql = "insert into products values(?,?,?,?,?,?,?,?,?,default)";

		return this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count);
				ps.setString(2, dto.getCategory_fk());
				ps.setString(3, dto.getProducts_name());
				ps.setString(4, dto.getEp_code_fk());
				ps.setInt(5, dto.getInput_price());
				ps.setInt(6, dto.getOutput_price());
				ps.setInt(7, dto.getTrans_cost());
				ps.setInt(8, dto.getMileage());
				ps.setString(9, dto.getCompany());
			}
		});
	}

	@Override
	public ProductsDTO getProductCont(int pnum) {

		sql = "select * from products where pnum = ?";
		return this.template.queryForObject(sql, new RowMapper<ProductsDTO>() {

			@Override
			public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductsDTO dto = new ProductsDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProducts_name(rs.getString("products_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));

				return dto;
			}
		}, pnum);
	}

	@Override
	public int updateProduct(final ProductsDTO dto) {
		
		sql = "update products set input_price = ?, output_price = ?, trans_cost = ?, mileage = ? where pnum = ?";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getInput_price());
				ps.setInt(2, dto.getOutput_price());
				ps.setInt(3, dto.getTrans_cost());
				ps.setInt(4, dto.getMileage());
				ps.setInt(5, dto.getPnum());
			}
		});
	}

	@Override
	public int deleteProduct(int pnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CategoryDTO> getCategoryList() {
		List<CategoryDTO> list = null;

		sql = "select * from category order by cnum";

		return list = this.template.query(sql, new RowMapper<CategoryDTO>() {

			@Override
			public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryDTO dto = new CategoryDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setDelete_chk(rs.getString("delete_chk"));
				return dto;
			}
		});
	}

}
