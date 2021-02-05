package com.techelevator;

import java.util.Scanner;
//import com.techelevator.Inventory;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_FEEDING_MONEY = "Feeding Money";
	private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, 
			MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {MAIN_MENU_OPTION_FEEDING_MONEY, MAIN_MENU_OPTION_SELECT_PRODUCT, 
			MAIN_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private Inventory inventory;

	public VendingMachineCLI(Inventory inventory) {
		//this.inventory = new Inventory();
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("Display Here");
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				if(choice.equals(MAIN_MENU_OPTION_FEEDING_MONEY)) {

				} else if (choice.equals(MAIN_MENU_OPTION_SELECT_PRODUCT)) {

				} else if (choice.equals(MAIN_MENU_OPTION_FINISH_TRANSACTION)) {

				}
				// do purchase
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you, good bye!");
				System.exit(1);
				// exit
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}


}





