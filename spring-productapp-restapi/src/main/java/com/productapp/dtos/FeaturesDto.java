package com.productapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class FeaturesDto {

	private Integer featuresId;
	@NotNull
	private String color;
	@NotBlank(message ="material should not be blank")
	private String material;
	
	private String description;
}