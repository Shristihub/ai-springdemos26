package com.productapp.dtos;

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
public class OffersDto {
	private String offerName; //NO COST EMI, CASH BACK, PARTNER OFFER, BANK OFFER
	private Integer offerId;
	private String offerDesc;

}
