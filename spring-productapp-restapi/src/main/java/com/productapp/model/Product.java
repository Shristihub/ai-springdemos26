package com.productapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private int ratings;
	
	//Cascades says - save the child entity before saving the parent
	@OneToOne(cascade = CascadeType.PERSIST) //save the features object before the product 
	@JoinColumn(name = "features_id") // to give a different column name
	private Features features;
	
}




