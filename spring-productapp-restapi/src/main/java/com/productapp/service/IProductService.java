package com.productapp.service;

import java.util.List;

import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;

public interface IProductService {

	// using the built in methods of JpaRepo
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	//return a dto object only
	ProductDto getById(int productId) throws ProductNotFoundException;
	List<ProductDto> getAllProducts();

	// derived queries
	List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException;
	List<ProductDto> getByProductNameContains(String productname);
	
	List<String> getByNameHaving(String productname);

	

}
