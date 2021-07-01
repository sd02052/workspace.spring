package com.spring.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProductsDTO> getProductsList() {

		return this.sqlSession.selectList("list");
	}

	@Override
	public List<CategoryDTO> getCateList() {

		return this.sqlSession.selectList("cate");
	}

	@Override
	public int insertProducts(ProductsDTO dto) {

		return this.sqlSession.insert("insert", dto);
	}

	@Override
	public ProductsDTO getProductsCont(int pnum) {

		return this.sqlSession.selectOne("cont", pnum);
	}

	@Override
	public int updateProducts(ProductsDTO dto) {

		return this.sqlSession.update("update", dto);
	}

	@Override
	public int deleteProducts(int pnum) {

		return this.sqlSession.delete("delete", pnum);
	}

	@Override
	public List<ProductsDTO> searchList(String field, String keyword) {
		List<ProductsDTO> list = null;

		if (field.equals("products_name")) {
			list = this.sqlSession.selectList("products_name", keyword);
		} else {
			list = this.sqlSession.selectList("company", keyword);
		}

		return list;
	}

	@Override
	public void updateProductsNum(int pnum) {
		this.sqlSession.update("update_num", pnum);
	}

}
