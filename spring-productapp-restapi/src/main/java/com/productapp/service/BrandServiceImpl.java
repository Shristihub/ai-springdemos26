package com.productapp.service;

import org.springframework.stereotype.Service;

import com.productapp.config.ProductMapper;
import com.productapp.dtos.BrandDto;
import com.productapp.model.Brand;
import com.productapp.repository.IBrandRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true )
public class BrandServiceImpl implements IBrandService{
	
	IBrandRepository brandRepository;
	ProductMapper mapper;

	@Override
	public void addBrand(BrandDto brandDto) {
		Brand brand = mapper.toBrandEntity(brandDto);
		brandRepository.save(brand);
	}

	@Override
	public void updateBrand(BrandDto brandDto) {
		Brand brand = mapper.toBrandEntity(brandDto);
		brandRepository.save(brand);		
	}

	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
		
	}

	@Override
	public BrandDto getById(int brandId) {
		Brand brand = brandRepository.findById(brandId)
		  .orElseThrow(()->new RuntimeException("brand not found"));
		return mapper.toBrandDto(brand);
	}

	

}
