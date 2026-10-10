package com.productapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dtos.ProductDto;
import com.productapp.service.IProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/product-api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

	// autowire
	IProductService productService;
	// data comes in body part of the request - use @RequestBody to get the json
	// object

//	http://localhost:8081/product-api/v1/products    (method is post)
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
//		return status code 202 no body
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

//	http://localhost:8081/product-api/v1/products (method is put)
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody  ProductDto productDto) {
		productService.updateProduct(productDto);
		// return status code 202 no body
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

//	http://localhost:8081/product-api/v1/products (method is delete)
	@DeleteMapping("/products/id/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
//	http://localhost:8081/product-api/v1/products/id/1
	@GetMapping("/products/id/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable int productId) {
		ProductDto productDto = productService.getById(productId);
		// adding headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one product by id");
		// return a response entity object with status , header and body
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(productDto);

	}

//	http://localhost:8081/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> productDtos = productService.getAllProducts();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all products");
		headers.add("info", "Returning the product list");
		return ResponseEntity.ok().headers(headers).body(productDtos);
	}

//	http://localhost:8081/product-api/v1/products/price/1200
	@GetMapping("/products/price/{price}")
	ResponseEntity<List<ProductDto>> getByLesserPrice(@PathVariable double price) {
		List<ProductDto> productDtos = productService.getByLesserPrice(price);
		return ResponseEntity.ok(productDtos);
	}

//	http://localhost:8081/product-api/v1/products/name?productname=bottle
	@GetMapping("/products/name")
	ResponseEntity<List<ProductDto>> getByProductNameContains(@RequestParam String productname) {
		List<ProductDto> productDtos = productService.getByProductNameContains(productname);
		return ResponseEntity.ok(productDtos);
	}

//	http://localhost:8081/product-api/v1/products/productname/bottle
	@GetMapping("/products/productname/{name}")
	ResponseEntity<List<String>> getByNameHaving(@PathVariable String productname) {
		// returns only the product names
		List<String> productNames = productService.getByNameHaving(productname);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all products");
		headers.add("info", "Returning the product list");
		// use static method to create ResponseEntity
		return new ResponseEntity<>(productNames, headers, HttpStatus.OK.value());
	}
}
