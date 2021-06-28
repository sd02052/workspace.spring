package com.sist.model;

import java.util.List;

public interface ProductsDAO {

	List<ProductsDTO> getProductList();

	int insertProduct(ProductsDTO dto);

	ProductsDTO getProductCont(int pnum);

	int updateProduct(ProductsDTO dto);

	int deleteProduct(int pnum);

	List<CategoryDTO> getCategoryList();

	List<ProductsDTO> searchProductList(String field, String keyword);
}
