package com.techelevator;

public class Candy extends PurchasableItems {

	
	public Candy(String idNum, String name, String price, String type, int stockAmt) {
		super(idNum, name, price, type, stockAmt);
	}
	

	@Override
	public String getSound() {
		return "Munch Munch, Yum!";
	}
	


}