package com.techelevator;

public class Chips extends PurchasableItems {

	public Chips(String idNum, String name, String price, String type, int stockAmt) {
		super(idNum, name, price, type, stockAmt);
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
	


}
