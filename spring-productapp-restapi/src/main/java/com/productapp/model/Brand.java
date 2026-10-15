package com.productapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "products")
@Entity
public class Brand {

	@Id
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq",initialValue = 10,allocationSize = 1)
	private Integer brandId;
	@Column(length = 30)
	private String brandName;
	// one brand has - many products
	@OneToMany(mappedBy = "brand") //pass the instance variable from the Product Class
	private List<Product> products;



}
