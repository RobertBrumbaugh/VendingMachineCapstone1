package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Inventory {

	// Needs to stock vending machine at startup 
	// Sold out or not 
	// 
	public static void main(String []args) throws IOException {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter path: ");
		//String path = "vendingmachine.csv";
		String path = userInput.nextLine();
		File inputFile = new File(path);
		 
			try( Scanner fileToBeRead = new Scanner(inputFile)) {
				while(fileToBeRead.hasNext()) {
					String lineInput = fileToBeRead.nextLine();
					String[] wordsOnLine = lineInput.split("\\|" + "\\|" + "\\|");

					for(String line : wordsOnLine) {
						System.out.println(line);
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
