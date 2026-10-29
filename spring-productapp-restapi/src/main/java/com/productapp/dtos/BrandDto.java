package com.productapp.dtos;

import jakarta.validation.constraints.Size;
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
public class BrandDto {

	private Integer brandId;
	@Size(min = 3,max = 30,message="size should be between 3 and 30 char")
	
	private String brandName;

}
