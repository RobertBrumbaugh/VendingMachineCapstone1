package com.techelevator;

public class Candy extends PurchasableItems {

	public Candy(String idNum, String name, String price, String type) {
		super(idNum, name, price, type);
	}
	
	@Override
	public String getSound() {
		return "Munch Munch, Yum!";
	}
	


}