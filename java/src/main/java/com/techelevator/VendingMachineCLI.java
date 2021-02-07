package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.MoneyHolder;
import com.techelevator.PurchasableItems;
import com.techelevator.view.Menu;
import com.techelevator.FileWriter;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String PURCHASE_MENU_OPTION_FEEDING_MONEY = "Feeding Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, 
			MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEEDING_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
			PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;


	private List<PurchasableItems> vendingItems = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private Inventory inventory = new Inventory();

	private MoneyHolder moneyHolder = new MoneyHolder();
	

	public VendingMachineCLI() {

	}

	public void run() throws FileNotFoundException {
		
		
		
		FileWriter fileWriter = new FileWriter();
		
		

		TreeMap<String, PurchasableItems> inventorySelection = new TreeMap<>();
		try {
			List<PurchasableItems> purchasableItems = inventory.loadItems();
	
			for(PurchasableItems vendingItem : purchasableItems) {
				inventorySelection.put(vendingItem.getidNum(), vendingItem);
			}
	
			vendingItems = purchasableItems;

		} catch (FileNotFoundException e) {
			System.out.println("Unable To Find Inventory File");
		}


		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("-----| Vendo-Matic's Premium Products |-----");

				//Implement output of items from inventory

				for(PurchasableItems item : vendingItems)
				{
					System.out.println(item.toString());
				}


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				
				


				while(true) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEEDING_MONEY)) {

						//Ask user for money and update balance

						System.out.println("Please Insert $: \n--We Accept $10, $5, $2, and $1--");
						Scanner userInput = new Scanner(System.in);
						String input = userInput.nextLine();
						int amountDeposited = Integer.parseInt(input);
						moneyHolder.depositedMoneyConvertedToPennies(amountDeposited);
						System.out.println("Current Money Provided: $" + String.format("%.2f", moneyHolder.balance));

						try {
							fileWriter.logWriter("Feed Money: " + " $" + amountDeposited + " $" + String.format("%.2f", moneyHolder.balance) +"\n");
						} catch (IOException e) {
							System.out.println("Invalid Log Method!");
						}
							
						

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						
						
						for(PurchasableItems item : vendingItems)
						{
							System.out.println(item.toString());
						}
						
						String itemChoice = menu.getItemChoice();
						
						PurchasableItems chosenItem = inventorySelection.get(itemChoice);

						
						if(chosenItem != null) {
							
							List<PurchasableItems> shoppingCart  = new ArrayList<>();

							shoppingCart.add(chosenItem);
							
							if(chosenItem.equals(inventorySelection.get(itemChoice))) {
								
								if(Double.valueOf(chosenItem.getPriceString()) <= moneyHolder.balance) {
									inventory.distributeProductAmount(itemChoice);
									
									Double newBalance = moneyHolder.balance;
									moneyHolder.balance = moneyHolder.balance - Double.valueOf(chosenItem.getPriceString());
									
									
									
									System.out.println("Items To Vend: " + chosenItem.getName() + " $" + chosenItem.getPriceString());
									System.out.println("Current Balance: $" + String.format("%.2f", moneyHolder.balance));
									
									try {
										fileWriter.logWriter(chosenItem.getName() + " " + chosenItem.getidNum() +
												" $" +  String.format("%.2f", newBalance)  + " $" + String.format("%.2f", moneyHolder.balance) +"\n");
									} catch (IOException e) {
										System.out.println("Invalid Log Method!");
									}
									
								}else {
									System.out.println("Insufficient Funds!");
								}
								
							}else{
								if (itemChoice == null){
									
									System.out.println("Invalid Entry: Please Make A Valid Selection!");
								}
			
							}
							
							
						}else {
							System.out.println("Please Make A Valid Selection!");
						}
							

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

						moneyHolder.convertToCoins(moneyHolder.balance * 100);
						double newBalance = moneyHolder.balance;
						moneyHolder.balance = 0;
						System.out.println("Current Balance: $" + String.format("%.2f", moneyHolder.balance));
						System.out.println("Thank You, Goodbye!");
						
						try {
							fileWriter.logWriter("Give Change: " + " $" + String.format("%.2f", newBalance) + " $" + String.format("%.2f", moneyHolder.balance) +"\n");
						} catch (IOException e) {
							System.out.println("Invalid Log Method!");
						}
						// message!! "Give Change: " + " $" + amtBalance + mhBalance;
						
						break;

					}
				}

				// do purchase
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank You, Goodbye!");
				System.exit(1);

			}
		}
}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.run();
		} catch (FileNotFoundException e) {
			
		}


	}


}





