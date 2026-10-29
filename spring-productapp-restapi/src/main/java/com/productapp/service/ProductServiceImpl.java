package com.productapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
				.orElseThrow(() -> new ProductNotFoundException("invalid id"));
		// convert entity into dto object - call the method of ProductMapper
		return mapper.toProductDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		// get all the products sorted by db itself
		List<Product> products = productRepository.findAll(Sort.by("productName"));
		// convert list of products to list of dtos
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPriceLessThan(price);
		// convert list of products to list of dtos
		return products.stream().map(product -> mapper.toProductDto(product))
				.sorted(Comparator.comparing(ProductDto::getProductName)).toList();
	}

	@Override
	public List<ProductDto> getByProductNameContains(String productname) {
		// using custom query
		List<Product> products = productRepository.findByname("%" + productname + "%");
		if (products.isEmpty())
			throw new ProductNotFoundException("not found");
		return products.stream().map(product -> mapper.toProductDto(product))
				.sorted(Comparator.comparing(ProductDto::getProductName)).toList();
	}

	@Override
	public List<String> getByNameHaving(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByColor(String color) {
		// using custom query - returns the products by color sorted by price in
		// descending order high to low
		List<Product> products = productRepository.findByColor(color, Sort.by(Direction.DESC, "price", "productName"));
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this color not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByoffers(String offername) throws ProductNotFoundException {
		List<Product> products = productRepository.findByoffers(offername);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this offer not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByColorAndLesserPrice(String color, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByColorAndLesserPrice(color, price);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this color not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException {
		System.out.println(category+" "+brand);
		List<Product> products = productRepository.findByCategoryAndBrand(category, brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this category and brand not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByDeliveryTypes(String delivery) throws ProductNotFoundException {
		List<Product> products = productRepository.findByDeliveryTypes(delivery);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this delivery not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByPaymentAndDelivery(String payment, String delivery) throws ProductNotFoundException {
		List<Product> products = productRepository.findByPaymentAndDelivery(payment, delivery);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this payment and  delivery not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getByCatBrandOffer(String category, String brand, String offerName)
			throws ProductNotFoundException {
		List<Product> products = productRepository.findByCatBrandOffer(category, brand, offerName);
		if (products.isEmpty())
			throw new ProductNotFoundException("product with this category,brand,offername not found");
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
	}

	@Override
	public List<ProductDto> getAllProducts(int pageNo, int itemcount) {
		
		// pagenumber, no of items to be shown, sorting by
		Pageable pageref = PageRequest.of(pageNo, itemcount); 
//		Pageable pageref = PageRequest.of(pageNo, itemcount, Sort.by("productName")); 
		Page<Product> products = productRepository.findAll(pageref);
		// convert list of products to list of dtos
		return products.stream().map(product -> mapper.toProductDto(product)).toList();
		
	}

}
