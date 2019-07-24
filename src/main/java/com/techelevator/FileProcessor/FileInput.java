package com.techelevator.FileProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import com.techelevator.Items.Item;


public class FileInput {
		
	Display display = new Display();
	
	public TreeMap<String, Item> createMapForMenu() throws FileNotFoundException{
		
		File file = new File("vendingmachine.csv");	
		
		TreeMap<String, Item> menu = display.createDisplay(file);
		
		return menu;
	}		
}
	
