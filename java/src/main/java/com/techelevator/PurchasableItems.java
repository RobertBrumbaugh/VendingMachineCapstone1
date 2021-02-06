package com.techelevator;

public class PurchasableItems {

	private String name;
	private String price;
	private String type;
	private String idNum;
	private String sound;
	private int count;

	//TODO: Full Constructor needed
	
	
	public PurchasableItems(String idNum, String name, String price, String type) {

		this.name = name;
		this.price = price;
		this.type = type;
		this.idNum = idNum; 
		//add count to classes
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

	public String getSound() {
		return sound;
	};
	
	
	@Override
	public String toString() {
		String result;
		result = this.idNum + ") " + this.name + " -- $" + this.price;
		return result;
	}
	
	public int decreaseCount() {
		return this.count -= 1;
	}

}
