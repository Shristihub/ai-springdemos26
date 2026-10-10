package com.productapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
	
	private  final IProductRepository productRepository;
		
	@Override
	public void addProduct(Product product) {
		//call the method of CRUDRepo
//		product without id - create an id and create a new product in the table - inserted
//		product with id - check if id exists - 
//		if yes update the product else 
//		create new product in the table - inserted
		
		Product savedproduct =  productRepository.save(product);
		System.out.println(savedproduct);
	}

	@Override
	public void updateProduct(Product product) {
//		send product with id
//		product with id - check if id exists - 
//		if yes update the product else 
//		create new product in the table - inserted
		Product updatedproduct =  productRepository.save(product);
		System.out.println(updatedproduct);
	}
		

	@Override
	public void deleteProduct(int productId) {
			productRepository.deleteById(productId);
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		Optional<Product> productopt = productRepository.findById(productId);
		if(productopt.isPresent()) {
			return productopt.get();
		}else
			throw new ProductNotFoundException("invalid id");
		
//		return productRepository.findById(productId)
//						 .orElseThrow(()->new ProductNotFoundException("invalid id"));	
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products =  productRepository.findByPriceLessThan(price);
		List<Product> productsByPrice = products.stream()
				.sorted(Comparator.comparing(Product::getProductName)).toList();
		if(productsByPrice.isEmpty())
			throw new ProductNotFoundException("product with this proce not available");
		return productsByPrice;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		List<Product> products =  productRepository.findByBrand(brand);
		List<Product> productsByBrand = products.stream()
				.sorted(Comparator.comparing(Product::getProductName)).toList();
		if(productsByBrand.isEmpty())
			throw new ProductNotFoundException("product with this brand not available");
		return productsByBrand;
	}

	@Override
	public List<Product> getByProductNameContains(String productname) {
		List<Product> products =  productRepository.findByProductNameContains(productname);
		List<Product> productsByName = products.stream()
				.sorted(Comparator.comparing(Product::getProductName)).toList();
		if(productsByName.isEmpty())
			throw new ProductNotFoundException("product with this proce not available");
		return productsByName;
	}

	@Override
	public List<Product> getByBrandPrice(String brand, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCatBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCatPrice(String category, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
