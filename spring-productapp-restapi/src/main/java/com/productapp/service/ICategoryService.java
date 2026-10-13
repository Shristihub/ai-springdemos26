package com.productapp.service;

import java.util.List;

import com.productapp.dtos.CategoryDto;

public interface ICategoryService {

	// using the built in methods of JpaRepo
	void addCategory(CategoryDto categoryDto);

	void updateCategory(CategoryDto categoryDto);

	void deleteCategory(int categoryId);

	// return a dto object only
	CategoryDto getById(int categoryId);

	List<CategoryDto> getAll();
}
