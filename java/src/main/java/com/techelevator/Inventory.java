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
	
	//Potential Dead Code?
//	public Inventory(PurchasableItems purchasableItems, String itemName, int stockAmount) {
//		this.itemName = itemName;
//		this.stockAmount = stockAmount;
//	}

	public List<PurchasableItems> getPurchasableItems() {
		return purchasableItems;
	}

		//Not sure if needed after INITAL STOCK AMOUNT
	public int getStockAmount() {
		return stockAmount;
	}

	public int getDispenseAmount() {
		return dispenseAmount;
	}

	public String getItemName() {
		return itemName;
	}

	
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
//		// LOGIC HERE Checks out
//		if(result) {
//			System.out.println(dispensedItem.getSound() + ", Thank you! \n" );
//		}else{
//			System.out.println("Sorry, item is SOLD OUT! \n");
//		}
		System.out.println(getMessage(result, dispensedItem));
		return result;
		
	}
	
	//for testing
	public String getMessage(boolean result, PurchasableItems item) {
		
		if (result = true ) {
			return item.getSound() + ", Thank you! \n" ;
		} else {
			return "Sorry, item is SOLD OUT! \n";
		}
		
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

