package com.techelevator;

public abstract class PurchasableItems {

	private String name;
	private String price;
	private String type;
	private String idNum;

	//TODO: Full Constructor needed
	
	
	public PurchasableItems(String idNum, String name, String price, String type) {

		this.name = name;
		this.price = price;
		this.type = type;
		this.idNum = idNum; 

	}

	public String getName() {
		return name;
	}

	public String getPriceString() {
		return price;
	}
	
	public String getidNum() {
		return idNum;
	}
	
	public String getType(){
		return type;
	}

	/*
	 * public int getMaxNumberOfItems() { return maxNumberOfItems; }
	 */

	public abstract String getSound();
	
	
	@Override
	public String toString() {
		String result;
		result = this.idNum + ") " + this.name + " -- $" + this.price;
		return result;
	}

}
