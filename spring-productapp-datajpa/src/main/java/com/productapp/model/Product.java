package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
public class Product {
    @Column(length = 25)
	private String productName;
	@Id
	@GeneratedValue //auto generate the id
	private Integer productId;
	@Column(name = "cost") // the column name will be cost
	private double price;  // use "price" for JPQL queries cost for "sql"
	private String brand;
	private String category;
	private int ratings;
	
}




