package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	// derived queries - use only instance variable names
	List<Product> findByBrand(String brand);

	List<Product> findByPriceLessThan(double price);

	List<Product> findByProductNameContains(String productname);

//	List<Product> findByBrandAndPriceLessThan(String brand, double price);

	// custom query - JPQL
	// any method name - use @Query pass only the entity name, only instance variable names
	@Query("select pi from Product pi where pi.brand = ?1and pi.price=?2")
	List<Product> findByBrandPrice(String brand, double cost);
	
	@Query("select pi from Product pi where pi.category=?1 and pi.brand=?2")
	List<Product> findByCatBrand(String category, String brand);
	
	//native query - pass the table name, also the column names(cost)
	@Query(value = 
			"""
			select * from product p where p.category=?1 and p.cost=?2
			""",
		   nativeQuery = true)
	List<Product> findByCatPrice(String category, double price);

}







