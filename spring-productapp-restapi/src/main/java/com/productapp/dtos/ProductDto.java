package com.productapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
	private String productName;
	private Integer productId;
	private double price; 
	private int ratings;
	private FeaturesDto features;
	
}