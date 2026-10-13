package com.productapp.model;

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
public class Offers {
	private String offerName; //NO COST EMI, CASH BACK, PARTNER OFFER, BANK OFFER
	@Id
	@GeneratedValue(generator = "offers_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offers_gen", sequenceName = "offers_seq", initialValue = 100, allocationSize = 1)
	private Integer offerId;
	private String offerDesc;

}
