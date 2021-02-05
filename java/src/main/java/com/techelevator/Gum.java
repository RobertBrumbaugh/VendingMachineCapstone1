package com.techelevator;

public class Gum extends PurchasableItems {

	public Gum(String idNum, String name, String price, String type) {
		super(idNum, name, price, type);
	}
	
	
	@Override
	public String getSound() {
		return "Chew Chew, Yum!";
	}
	


}