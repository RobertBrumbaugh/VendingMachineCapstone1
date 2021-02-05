package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import com.techelevator.PurchasableItems;

public class Inventory {

	// Needs to stock vending machine at startup 
	// Sold out or not 
	private PurchasableItems purchasableItems;
	private static int stockAmount = 5;
	private int dispenseAmount = 0;
	private String itemName;

	public Inventory(PurchasableItems purchasableItems, String itemName) {
		this.purchasableItems = purchasableItems;
		this.itemName = itemName;
		this.stockAmount = stockAmount;
	}

	public PurchasableItems getPurchasableItems() {
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
			stockAmount++;
			dispenseAmount--;
			
		} else if (stockAmount == 0) {
			System.out.println("Sorry, item is SOLD OUT!");
		}

	}


	public static void main(String []args) throws IOException {

		Scanner getFileToDisplay = new Scanner("vendingmachine.csv");
		//System.out.println("Enter path: ");
		//String path = "vendingmachine.csv";
		String path = getFileToDisplay.nextLine();
		File inputFile = new File(path);

		try( Scanner fileToBeRead = new Scanner(inputFile)) {
			while(fileToBeRead.hasNext()) {
				String lineInput = fileToBeRead.nextLine();
				String[] wordsOnLine = lineInput.split("\\|" + "\\|" + "\\|");

				for(String line : wordsOnLine) {
					System.out.println(line + "| " + stockAmount);
				}


				//
				//		public boolean isNotSoldOut() {
				//			if(this.maxNumberOfItems >= 1) {
				//				return true;
				//			}
				//			return false;
				//		}
				//
				//		public void purchaseItemInstance() {
				//			maxNumberOfItems -= 1;
				//		}
			}
		}}}
