package com.techelevator;

public class PurchasableItems {

	private String name;
	private String price;
	private String type;
	private String idNum;
	private String sound;
	private int count;
	
	
	public void setCount(int count) {
		this.count = count;
	}

	public PurchasableItems(String idNum, String name, String price, String type, int stockAmt) {

		this.name = name;
		this.price = price;
		this.type = type;
		this.idNum = idNum; 
		this.count = stockAmt;
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

	public String getSound() {
		return sound;
	}
	
	public int getCount() {
		return count;
	}
	
	
	//TODO: ADD ADDITIONAL DATA LIKE COUNT TO toString()
	@Override
	public String toString() {
		String result;
		result = this.idNum + ") " + this.name + " -- $" + this.price + " -- " + this.count + " Available";
		return result;
	}
	
	public int decreaseCount() {
		return this.count -= 1;
	}

}
