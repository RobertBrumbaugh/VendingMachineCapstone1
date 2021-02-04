package com.techelevator;

public abstract class PurchasableItems {

	private String name;
	private String price;
	private int maxNumberOfItems = 5;

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

	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}

	public abstract String getSound();

}

	//	public Integer getPriceIntegerToPennies() {
	//		getPriceIntegerToPennies();
	//		return Integer.parseInt(price);
	//	}

	// Could be in inventory??
//	public boolean isNotSoldOut() {
//		if(this.maxNumberOfItems >= 1) {
//			return true;
//		}
//		return false;
//	}
//	
//	public void purchaseItemInstance() {
//		maxNumberOfItems -= 1;
//	}



