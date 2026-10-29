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
	List<ProductDto> getByProductNameContains(String productname) throws ProductNotFoundException;;
	
	List<String> getByNameHaving(String productname)throws ProductNotFoundException;
	
	//pagination
	List<ProductDto> getAllProducts(int pageNo, int itemcount);
	//custom
	List<ProductDto> getByColor(String color)throws ProductNotFoundException;
	List<ProductDto> getByoffers(String offername)throws ProductNotFoundException;
	List<ProductDto> getByColorAndLesserPrice(String color,double price) throws ProductNotFoundException;
	List<ProductDto> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException;
	List<ProductDto> getByDeliveryTypes(String delivery) throws ProductNotFoundException;
	List<ProductDto> getByPaymentAndDelivery(String payment,String delivery) throws ProductNotFoundException;
	List<ProductDto> getByCatBrandOffer(String category, String brand, String offerName) throws ProductNotFoundException;
	
	

	

}
