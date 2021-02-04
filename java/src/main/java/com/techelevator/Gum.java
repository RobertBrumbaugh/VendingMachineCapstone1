package com.techelevator;

public class Gum extends PurchasableItems {

	public Gum(String name, String price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Chew Chew, Yum!";
	}


}
