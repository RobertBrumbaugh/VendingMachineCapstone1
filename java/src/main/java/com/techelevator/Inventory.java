package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.PurchasableItems;

public class Inventory {

	// Needs to stock vending machine at startup 
	// Sold out or not 
	private List<PurchasableItems> purchasableItems = new ArrayList<>();
	private static final int INITIAL_STOCK_AMOUNT = 5;
	private static int stockAmount = 5;
	private int dispenseAmount = 0;
	private String itemName;

	
	public Inventory() {
		
	}
	
	
	public Inventory(PurchasableItems purchasableItems, String itemName, int stockAmount) {
	//	this.purchasableItems = purchasableItems;
		this.itemName = itemName;
		this.stockAmount = stockAmount;
	}

	public List<PurchasableItems> getPurchasableItems() {
		return purchasableItems;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public int getDispenseAmount() {
		return dispenseAmount;
	}

	public String getItemName() {
		return itemName;
	}

	//TODO: STRIP ALL DEAD CODE BEFORE RELEASE
//	public void distributeProductAmount() {
//		
//		if (stockAmount > 0) {
//			stockAmount--;
//			dispenseAmount++;
//			
//		} else if (stockAmount == 0) {
//			System.out.println("Sorry, item is SOLD OUT!");
//		}
//
//	}
	
	public boolean distributeProductAmount(String itemSlot) {
		
		boolean result = false;
		PurchasableItems dispensedItem = null;
		
		for(PurchasableItems item : purchasableItems) {
			if(item.getidNum().equals(itemSlot)) {
				
				if(item.getCount() > 0) {
					item.decreaseCount();
					dispensedItem = item;
					result = true;
				}
				
			}
		}
		
		//TODO: REVIEW LOGIC HERE
		if(result) {
			System.out.println(dispensedItem.getSound() + ", Thank you!");
		}else{
			System.out.println("Sorry, item is SOLD OUT!");
		}

		return result;
		
	}
	
	public List<PurchasableItems> loadItems() throws FileNotFoundException {
		
		Scanner getFileToDisplay = new Scanner("vendingmachine.csv");
		String path = "vendingmachine.csv";
		File inputFile = new File(path);

		try( Scanner fileToBeRead = new Scanner(inputFile)) {
			while(fileToBeRead.hasNext()) {
				String lineInput = fileToBeRead.nextLine();

				String[] itemAttributes = lineInput.split("\\|");
				
				switch(itemAttributes[3]) {
				case "Chip":
					purchasableItems.add(new Chips(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3], INITIAL_STOCK_AMOUNT ));
					break;
				case "Candy":
					purchasableItems.add(new Candy(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3], INITIAL_STOCK_AMOUNT));
					break;
				case "Drink":
					purchasableItems.add(new Drinks(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3], INITIAL_STOCK_AMOUNT));
					break;
				case "Gum":
					purchasableItems.add(new Gum(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3], INITIAL_STOCK_AMOUNT));
					break;
				default:
					break;
				}
				
				

			}
		}
		
		return purchasableItems;
		
	}	
	}

