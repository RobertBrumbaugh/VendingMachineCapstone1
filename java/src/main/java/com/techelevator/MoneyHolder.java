	package com.techelevator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoneyHolder {
	
		//TODO: Implement the change return in CLI
	
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
				System.out.println("Invalid entry: Please Enter $1, $2, $5, or $10");
			}
			return;
		}
	
	//	public void withdrawMoneyConvertedToPennies ( int amountWithdrawn) {
	//		balance = balance + amountWithdrawn;
	//	}
	
		
		//TODO: Datatype issue with Balance, check and make it Double/BigDecimal
		public void convertToCoins(int balance) {
			
			//int counter = this.balance;
			int quartersToReturn = 0;
			int dimesToReturn = 0;
			int nickelsToReturn = 0;
			double quarterValue = 0.25;
			double dimeValue = 0.10;
			double nickelValue = 0.05;
	
	
			while (balance > 0) {
				if (balance >= quarterValue) {
					quartersToReturn ++;
					balance = (int) (balance - quarterValue);
				} else if (balance >= dimeValue) {
					dimesToReturn++;
					balance = (int) (balance - dimeValue);
				} else if (balance >= nickelValue) {
					nickelsToReturn++;
					balance = (int) (balance - nickelValue);
				}
			}
			System.out.println(quartersToReturn + " Quarters " + dimesToReturn + " Dimes " + nickelsToReturn
					+ " Nickels");
	
		}
	}
	

		
		