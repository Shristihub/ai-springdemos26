package com.productapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
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
	
//	List<Product> findByFeaturesColor(String color);
	
	//custom
	// get the products by color and sort by anything
	//add another parameter in this method - Sort sort
	@Query("select p from Product p join p.features f where f.color=?1")
	List<Product> findByColor(String color, Sort sort);
	
	//use native query
	@Query(value=
			"""
			select p from product p inner join p.offers o where o.offer_name=?1
			""",
			nativeQuery = true)
	List<Product> findByoffers(String offername);
	
	//custom
	@Query(
			"""
			select p from Product p 
			join p.features f 
			where f.color=?1and p.price<?2
			""")
	List<Product> findByColorAndLesserPrice(String color,double price) ;
	
	//custom
	@Query(
			"""
			select p from Product p 
			join p.categories c 
			join p.brand b
			where c.categoryName=?1 
			and b.brandName=?2
				""")
	List<Product> findByCategoryAndBrand(String category, String brand) ;
	
	// custom
	@Query(
			"""
			select p from Product p 
			join p.deliveryTypes dt 
			where dt=?1
				""")
	List<Product> findByDeliveryTypes(String delivery) ;
	@Query(
			"""
			select p from Product p 
			join p.deliveryTypes dt 
			join p.paymentMode pm
			where pm=?1 and dt=?2
				""")
	List<Product> findByPaymentAndDelivery(String payment,String delivery) ;
	
	@Query(
			"""
			select p from Product p 
			join p.categories c 
			join p.brand b
			join p.offers o
			where c.categoryName=?1
			and b.brandName=?2
			and o.offerName=?3
				""")
	List<Product> findByCatBrandOffer(String category, String brand, String offerName) ;
	
	
	
}







