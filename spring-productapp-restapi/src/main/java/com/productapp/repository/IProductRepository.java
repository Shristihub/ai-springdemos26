package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByProductNameContains(String productName);
	
	// same using custome query
	// select * from product where product_name like %name%
	@Query("select p from Product p where p.productName like ?1")
	List<Product> findByname(String productName);
}







