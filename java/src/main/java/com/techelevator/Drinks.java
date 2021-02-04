package com.techelevator;

public class Drinks extends PurchasableItems {

	public Drinks(String name, String price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Gulp Gulp, Yum!";
	}
	


}