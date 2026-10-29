package com.productapp.dtos;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
	@NotNull
	@NotEmpty(message = "productname should not be empty")
	private String productName;
	private Integer productId;
	@Positive(message = "value should be greater than 0")
	private double price; 
	@Min(value = 1,message = "Value must not be less than 1")
	@Max(value = 5, message = "Value must not be greater than 5")
	private int ratings;
	private FeaturesDto features; //one to one
	private List<OffersDto> offers; //one to many
	private List<CategoryDto> categories; //many to many
	private BrandDto brand; // many to one
	private List<String> paymentMode; 
	private List<String> deliveryTypes;
	
	
}





