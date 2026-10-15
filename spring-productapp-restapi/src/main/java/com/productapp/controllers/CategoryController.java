package com.productapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	void updateCategory(CategoryDto categoryDto) {

	}

	void deleteCategory(int categoryId) {

	}

	CategoryDto getById(int categoryId) {
		return null;
	}

	List<CategoryDto> getAll() {
		return null;
	}

}
