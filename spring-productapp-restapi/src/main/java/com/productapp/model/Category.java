package com.productapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Category {

	@Id
	@GeneratedValue(generator = "categories_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "categories_gen",sequenceName = "categories_seq",initialValue = 20,allocationSize = 1)
	private Integer categoryId;
	@Column(length = 30)
	private String categoryName;
	// one category has - many products
	//pass the instance variable that is the owner of this relationship
	@ManyToMany(mappedBy = "categories")
	private List<Product> products;



}
