package com.techelevator;

public class Gum extends PurchasableItems {

	public Gum(String idNum, String name, String price, String type, int stockAmt) {
		super(idNum, name, price, type, stockAmt);
	}
	
	
	@Override
	public String getSound() {
		return "Chew Chew, Yum!";
	}
	


}