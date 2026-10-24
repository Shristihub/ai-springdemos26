package com.productapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dtos.CategoryDto;
import com.productapp.service.ICategoryService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/product-api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

	ICategoryService categoryService;

//	http://localhost:8081/product-api/v1/categories    (method is post)
	@PostMapping("/categories")
	ResponseEntity<Void> addCategory(@RequestBody CategoryDto categoryDto) {
		categoryService.addCategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	http://localhost:8081/product-api/v1/categories    
	@PutMapping("/categories")
	ResponseEntity<Void> updateCategory(@RequestBody CategoryDto categoryDto) {
		categoryService.updateCategory(categoryDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

//	http://localhost:8081/product-api/v1/categories/id/1  
	@DeleteMapping("/categories/id/{categoryId}")
	ResponseEntity<Void> deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

//	http://localhost:8081/product-api/v1/categories/id/1
	@GetMapping("/categories/id/{categoryId}")
	ResponseEntity<CategoryDto> getById(@PathVariable int categoryId) {
		return ResponseEntity.ok(categoryService.getById(categoryId));
	}

//	http://localhost:8081/product-api/v1/categories
	@GetMapping("/categories")
	ResponseEntity<List<CategoryDto>> getAll() {
		return ResponseEntity.ok(categoryService.getAll());
	}

}
