package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;

import com.techelevator.FileProcessor.Display;
import com.techelevator.FileProcessor.FileInput;
import com.techelevator.FileProcessor.LogOutput;
import com.techelevator.FileProcessor.SalesReportReader;
import com.techelevator.FileProcessor.SalesReportWriter;
import com.techelevator.Items.Item;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	

	public Menu(InputStream input, OutputStream output) throws FileNotFoundException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		this.displayItems = generateMenu();
	}


Wallet transactionWallet = new Wallet();
LogOutput log = new LogOutput();
FileInput availableItems = new FileInput();
Display display = new Display();
TreeMap <String, Item> displayItems;
SalesReportWriter salesReport = new SalesReportWriter();

public void displayInitialPrompt () {
		System.out.println("Welcome To Vendo-Matic 500!! Please select an option:");
		System.out.println("Press 1 to Display Items");
		System.out.println("Press 2 to Make a Purchase");	
		System.out.flush();
	}
		
public void getOption() throws IOException{
		String option = in.nextLine();
		int value = Integer.parseInt(option);
		if (value ==1) {
			displayItems();
		}else if (value ==2) {
			beginPurchaseProcess();
		}else {
			System.out.println("Please enter only 1 or 2");
		}
		}
	
	
	public void displayItems() throws FileNotFoundException {

		
		for(Map.Entry<String, Item> position : displayItems.entrySet()) {
			String key = position.getKey();
			Item value = position.getValue();
			String name = value.getName();
			BigDecimal price = value.getPrice();
			String type = value.getType();
			int stock = value.getStock();
			
			System.out.printf("%3s %-20s %4s %-8s %2s", "|" + key, "|" + name, "|" + price, "|" + type, "|" + stock);
			System.out.println("");
			
		}
		
		
	}
	
	public void beginPurchaseProcess() throws IOException{
		
		System.out.println("Press (1) to Input Money");
		System.out.println("Press (2) to Select an Item");
		System.out.println("Press (3) to End Transaction and Receive Your Change");
		System.out.println("Your current balance is: $" + transactionWallet.getBalance());
		System.out.flush();
		int selection = in.nextInt();
		in.nextLine();
		if (selection ==1) {
			feedMoney();
		}else if (selection ==2) {
			getItem();
		} else if(selection ==3) {
			finishTransaction();
		}
	}
	
//This is the method that handles the money being put into the machine.
	public void feedMoney() throws IOException{
		System.out.println("Please input money");
		String inputFeedMoney = in.nextLine();
		BigDecimal valueOfInputFeedMoney = new BigDecimal(inputFeedMoney);
		if(valueOfInputFeedMoney.equals(new BigDecimal(1)) ||
			valueOfInputFeedMoney.equals(new BigDecimal(2)) ||
			valueOfInputFeedMoney.equals(new BigDecimal(5)) ||
			valueOfInputFeedMoney.equals(new BigDecimal(10))) {
			transactionWallet.addMoney(valueOfInputFeedMoney);
			System.out.println("Your current balance = $"+ transactionWallet.getBalance());
			log.logTransaction(generateDate()+" || FEED MONEY || $" +valueOfInputFeedMoney + " || $"+ transactionWallet.getBalance());
			beginPurchaseProcess();
		} else {
		System.out.println("Only $1, $2, $5, and $10 bills accepted!");
		beginPurchaseProcess();
		}
	}	
	
//Method that gets the item	
	public void getItem() throws IOException {
		System.out.println("What item would you like to purchase?");
		String requestedItem = in.nextLine();
		Item selection = displayItems.get(requestedItem.toUpperCase());
		if(!displayItems.containsKey(requestedItem.toUpperCase())) {
			System.out.println("ITEM DOES NOT EXIST! PLEASE TRY AGAIN");
			beginPurchaseProcess();
		}
		if(selection.getStock() <= 0) {
			System.out.println("SOLD OUT");
			beginPurchaseProcess();
		}
		if (transactionWallet.getBalance().compareTo(selection.getPrice())>=0) {
		String name = selection.getName();
		String yumNoise = selection.reaction();
		selection.removeItem();
		transactionWallet.deductMoney(selection.getPrice());
		System.out.println(name +"\n" +yumNoise +"\nYour balance is " + transactionWallet.getBalance());
		log.logTransaction(generateDate()+" || " + selection.getName() +" || "+ transactionWallet.getBalance());
		}else {
			System.out.println("Please input more money.");
		}
	}
	
//Method that finishes the transaction
	public void finishTransaction() throws IOException {
		System.out.println("Here's your change!");
		int [] change = transactionWallet.makeChange();
		System.out.println("Your change is " +change[0] + " quarters " + change[1] + " dimes " + change[2] + " nickels");
		log.logTransaction(generateDate()+ "|| GIVE CHANGE ||" + transactionWallet.getBalance());
		transactionWallet.emptyBalance();
		salesReport.salesReportWriter();
	}	
	
public String generateDate() {
	String timestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a").format(new Date());
	return timestamp;
}	
	
public TreeMap <String, Item> generateMenu() throws FileNotFoundException{
	TreeMap <String, Item> chooseFromDisplay = availableItems.createMapForMenu();
	return chooseFromDisplay;
}


	
public void errorMessage() {
	System.out.println("An error occurred");

}
	
	
	
}


	
