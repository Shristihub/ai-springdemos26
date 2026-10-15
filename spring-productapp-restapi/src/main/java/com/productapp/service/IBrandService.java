package com.productapp.service;

import com.productapp.dtos.BrandDto;

public interface IBrandService {

	// using the built in methods of JpaRepo
	void addBrand(BrandDto brandDto);
	void updateBrand(BrandDto brandDto);
	void deleteBrand(int brandId);
	// return a dto object only
	BrandDto getById(int brandId);

}
