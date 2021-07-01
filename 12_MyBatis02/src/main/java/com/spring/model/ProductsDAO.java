package com.spring.model;

import java.util.List;

public interface ProductsDAO {

	public List<ProductsDTO> getProductsList();

	public List<CategoryDTO> getCateList();

	public int insertProducts(ProductsDTO dto);
	
	public ProductsDTO getProductsCont(int pnum);
	
	public int updateProducts(ProductsDTO dto);
	
	public int deleteProducts(int pnum);
	
	public void updateProductsNum(int pnum);
	
	public List<ProductsDTO> searchList(String field, String keyword);
}
