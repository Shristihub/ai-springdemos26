package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dtos.BrandDto;
import com.productapp.service.IBrandService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/product-api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandController {
	
	IBrandService brandService;
		
//	http://localhost:8081/product-api/v1/brands    (method is post)
	@PostMapping("/brands")
	ResponseEntity<Void> addBrand(@Valid @RequestBody BrandDto brandDto) {
		brandService.addBrand(brandDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	void updateBrand(BrandDto brandDto) {
		
	}
	void deleteBrand(int brandId) {
		
	}
	BrandDto getById(int brandId) {
		return null;
	}

}








