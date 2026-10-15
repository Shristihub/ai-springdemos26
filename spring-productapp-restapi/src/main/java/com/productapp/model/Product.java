package com.productapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	//Cascade says - save the child entity before saving the parent
	@OneToOne(cascade = CascadeType.ALL) //save the features object before saving the product 
	@JoinColumn(name = "features_id") // to give a different column name
	private Features features;
	
	@OneToMany(cascade = CascadeType.ALL)//save the offers object before saving  the product
	// removes junction table - adds product_id to offers table
	@JoinColumn(name = "product_id") 
	private List<Offers> offers;
	
	// one product in many categories
	@ManyToMany
	// to have only one junction table
	@JoinTable(name = "product_category",
	          joinColumns = @JoinColumn(name="product_id"),
	          inverseJoinColumns = @JoinColumn(name="category_id")
			)
	private List<Category> categories; // owner of this relationship
	
	//many products belong to one brand
	@ManyToOne
	@JoinColumn(name = "brand_id") // to give a different column name
	private Brand brand; // owner of this relationship
	
	// working with List<String>
	@ElementCollection
	@CollectionTable(name="payment_mode",
              joinColumns = @JoinColumn(name="product_id"))
	private List<String> paymentMode; //COD, CARD, UPI
	
	@ElementCollection
	// 2 columns 1-product_id, 2 delivery_types
	@CollectionTable(name="delivery_type",
	                 joinColumns = @JoinColumn(name="product_id"))
	private List<String> deliveryTypes; //Standard, Prime, Ekart
	
}




