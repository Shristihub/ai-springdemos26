package com.productapp.model.enums;

public enum OfferDetails {

	NCI("NO COST EMI"), 
	CB("CASH BACK"),
	PO("PARTNER OFFER"),
	BO("BANK OFFER");
	
	//create an instance variable 
	private String offerName;
	//add a parameterised constr

	private OfferDetails(String offerName) {
		this.offerName = offerName;
	}
	//create getter method for this

	public String getOfferName() {
		return offerName;
	}
	
}
