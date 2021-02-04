package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Inventory {

	// Needs to stock vending machine at startup 
	// Sold out or not 
	// 
public static void main(String []args) {

	try( Scanner fileToBeRead = new Scanner("vendingmachine.csv")) {
		while(fileToBeRead.hasNext()) {
			String lineInput = fileToBeRead.nextLine();
			String[] wordsOnLine = lineInput.split("\\|" + "\\|" + "\\|");
			
			for(String word : wordsOnLine) {
				System.out.println(word);
			}

		}
	}

}
}







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

