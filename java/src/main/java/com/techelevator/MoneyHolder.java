	package com.techelevator;
	
	import java.util.Arrays;
	import java.util.HashSet;
	import java.util.Set;
	
	public class MoneyHolder {
	
		
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
	
		//For Testing
			public double getBalance () {
				return balance;
			}
		
	
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
	

		