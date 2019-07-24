package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import com.techelevator.FileProcessor.LogOutput;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
		menu.displayInitialPrompt();
		try {
			menu.getOption();
		} catch (IOException e) {
			menu.errorMessage();
		} 
		}
	}


	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
