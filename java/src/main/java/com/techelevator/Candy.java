package com.techelevator;

public class Candy extends PurchasableItems {

	public Candy(String name, String price) {
		super(name, price);
	}
	
	@Override
	public String getSound() {
		return "Munch Munch, Yum!";
	}
	


}