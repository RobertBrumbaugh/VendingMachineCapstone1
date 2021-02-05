package com.techelevator;

public class Chips extends PurchasableItems {

	public Chips(String name, String price) {
		super(name, price);
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
	


}
