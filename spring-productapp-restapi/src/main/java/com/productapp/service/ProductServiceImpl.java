package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.config.ProductMapper;
import com.productapp.dtos.ProductDto;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;

	private final ProductMapper mapper;

	@Override
	public void addProduct(ProductDto productDto) {
		// convert the dto into entity - manualy or using a third party library
		// ModelMapper
		// call the method of ProductMapper
		Product product = mapper.toProductEntity(productDto);
		// call save method to insert
		productRepository.save(product);
	}
	@Override
	public void updateProduct(ProductDto productDto) {
		// call the method of ProductMapper
		Product product = mapper.toProductEntity(productDto);
		// call save method to insert
		productRepository.save(product);
	}
	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
		  .orElseThrow(()-> new ProductNotFoundException("invalid id"));
		// convert entity into dto object - call the method of ProductMapper
		return mapper.toProductDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		//get all the products
		List<Product> products = productRepository.findAll();
		//convert list of products to list of dtos
		return products.stream()
		        .map(product->mapper.toProductDto(product))
		        .toList();
	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPriceLessThan(price);
		//convert list of products to list of dtos
		return products.stream()
				.map(product->mapper.toProductDto(product))
		        .sorted(Comparator.comparing(ProductDto::getProductName))
		        .toList();
	}

	@Override
	public List<ProductDto> getByProductNameContains(String productname) {
		// using custome query
		List<Product> products = productRepository.findByname("%"+productname+"%");
		return products.stream()
				.map(product->mapper.toProductDto(product))
		        .sorted(Comparator.comparing(ProductDto::getProductName))
		        .toList();
	}

	@Override
	public List<String> getByNameHaving(String productname) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductDto> getByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
