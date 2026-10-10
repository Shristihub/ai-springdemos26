package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString
@Entity
public class Features {

	@Id
	@GeneratedValue(generator = "features_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "features_gen",sequenceName = "features_seq",initialValue = 50,allocationSize = 1)
	private Integer featuresId;
	@Column(length = 25)
	private String color;
	@Column(length = 25)
	private String material;
	private String description;
}




