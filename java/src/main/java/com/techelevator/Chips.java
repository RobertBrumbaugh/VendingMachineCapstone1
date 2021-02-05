package com.techelevator;

public class Chips extends PurchasableItems {

	public Chips(String idNum, String name, String price, String type) {
		super(idNum, name, price, type);
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
	


}
