package com.techelevator;

public abstract class PurchasableItems {

	private String name;
	private String price;
	//private int maxNumberOfItems = 5;

	//TODO: Full Constructor needed
	public PurchasableItems(String name, String price) {

		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public String getPriceString() {
		return price;
	}

	/*
	 * public int getMaxNumberOfItems() { return maxNumberOfItems; }
	 */

	public abstract String getSound();
	
	//TODO: Implement a .toString override to make these printable in a nice user friendly way
	
	@Override
	public String toString() {
		String result;
		result = this.name + " " + this.price;
		return result;
	}

}
