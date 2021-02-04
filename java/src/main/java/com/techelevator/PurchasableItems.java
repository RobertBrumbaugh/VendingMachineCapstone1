package com.techelevator;

public abstract class PurchasableItems {
	
	private String name;
	private String price;
	//private String id;

	public PurchasableItems(String name, String price) {
		
		this.name = name;
		this.price = price;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getPriceString() {
		return price;
	}
	
	public Integer getPriceIntegerToPennies() {
		getPriceIntegerToPennies();
		return Integer.parseInt(price);
	}

}
