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
	private static int stockAmount = 5;
	private int dispenseAmount = 0;
	private String itemName;

	
	public Inventory() {
		
	}
	
	
//	public Inventory(PurchasableItems purchasableItems, String itemName) {
//		this.purchasableItems = purchasableItems;
//		this.itemName = itemName;
//		this.stockAmount = stockAmount;
//	}

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

	public void distributeProductAmount() {
		
		if (stockAmount > 0) {
			stockAmount--;
			dispenseAmount++;
			
		} else if (stockAmount == 0) {
			System.out.println("Sorry, item is SOLD OUT!");
		}

	}
	
	//TODO: Update as appropriate
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
					purchasableItems.add(new Chips(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3]));
					break;//add count to this method after itemAttri.
				case "Candy":
					purchasableItems.add(new Candy(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3]));
					break;
				case "Drink":
					purchasableItems.add(new Drinks(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3]));
					break;
				case "Gum":
					purchasableItems.add(new Gum(itemAttributes[0],itemAttributes[1], itemAttributes[2], itemAttributes[3]));
					break;
				default:
					break;
				}
				
				

			}
		}
		
		return purchasableItems;
		
	}
//	public void vendingMachineSelection (String selection) {
//		
//		Set<String> snack = new HashSet<String>(Arrays.asList());
//		
//		if(snack.contains(selection)) {
//			//return selection;
//		} else {
//			System.out.println("Invalid entry: Please enter a valid slot entry");
//		}
//		return;
//	}
	
	}

