package com.techelevator;

public class Drinks extends PurchasableItems {

	public Drinks(String idNum, String name, String price, String type) {
		super(idNum, name, price, type);
	}
	
	
	@Override
	public String getSound() {
		return "Gulp Gulp, Yum!";
	}
	


}