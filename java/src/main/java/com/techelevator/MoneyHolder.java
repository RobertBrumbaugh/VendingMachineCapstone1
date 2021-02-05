	package com.techelevator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoneyHolder {
	
		// need a balance ==> converts to pennies
		// needs to add money (deposit - user's current balance)
		// + from user input 
		// needs to withdraw money
		// return change as pennies
		// convert pennies to quarters, dimes, nickels
		// update to 0 after each transaction
		public int balance;
	
	
		public MoneyHolder() {
			balance = 0;
		}
	
		public void depositedMoneyConvertedToPennies (int amountDeposited) {
			
			Set<Integer> validEntry = new HashSet<Integer>(Arrays.asList(new Integer[] {1, 2, 5, 10}));
			
			if(validEntry.contains(amountDeposited)) {
			balance = balance + amountDeposited;
			} else {
				System.out.println("Invalid entry: Please enter 1, 2, 5, or 10");
			}
			return;
		}
	
	//	public void withdrawMoneyConvertedToPennies ( int amountWithdrawn) {
	//		balance = balance + amountWithdrawn;
	//	}
	
		public String convertToCoins( int balance) {
			
			int counter = balance;
			int quartersToReturn = 0;
			int dimesToReturn = 0;
			int nickelsToReturn = 0;
			int quarterValue = 25;
			int dimeValue = 10;
			int nickelValue = 5;
	
	
			while (counter > 0) {
				if (counter >= quarterValue) {
					quartersToReturn ++;
					counter = counter - quarterValue;
				} else if (counter >= dimeValue) {
					dimesToReturn++;
					counter = counter - dimeValue;
				} else if (counter >= nickelValue) {
					nickelsToReturn++;
					counter = counter - nickelValue;
				}
			}
			return quartersToReturn + " quarters " + dimesToReturn + " dimes " + nickelsToReturn
					+ " nickels";
	
		}
	}
	

		
		