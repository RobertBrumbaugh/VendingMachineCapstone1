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
		public double balance;
	
	
	
	
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
		
		
		//TODO: check if this actually does anything
		public void subtractCostOfItemsFromBalance(int amountWithdrawn) {
			balance = balance-amountWithdrawn;
		}
	
	
		//TODO: Datatype issue with Balance, check and make it Double/BigDecimal
		public void convertToCoins(double balance) {
			
			
			double change = balance;
			
			int quartersToReturn = 0;
			int dimesToReturn = 0;
			int nickelsToReturn = 0;
			
			double quarterValue = 25;
			double dimeValue = 10;
			double nickelValue = 5;
	
	
			while (change > 0) {
				if (change >= quarterValue) {
					quartersToReturn ++;
					change = (int) (change - quarterValue);
				} else if (change >= dimeValue) {
					dimesToReturn++;
					change = (int) (change - dimeValue);
				} else if (change >= nickelValue) {
					nickelsToReturn++;
					change = (int) (change - nickelValue);
				}
	
	
			}
			System.out.println("Dispensing: " + quartersToReturn + " Quarters, " + dimesToReturn + " Dimes, " + nickelsToReturn
					+ " Nickels");
		}
	}
	

		