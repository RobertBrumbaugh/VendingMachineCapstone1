package com.techelevator;

public class Drinks extends PurchasableItems {

	public Drinks(String idNum, String name, String price, String type, int stockAmt) {
		super(idNum, name, price, type, stockAmt);
	}
	
	
	@Override
	public String getSound() {
		return "Gulp Gulp, Yum!";
	}
	


}