package com.techelevator.FileProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.Items.Item;

public class Display {
	
	
	public TreeMap<String, Item> createDisplay(File file) throws FileNotFoundException{
	
		
	TreeMap<String, Item> display = new TreeMap<String, Item>();	
	
	Slot slot = new Slot();
	
		try(Scanner fileScanner = new Scanner(file)){
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine().trim();
				String[] item = line.split("[|]");
						
				String position = item[0];
				String name = item[1];
				String price = item[2];
				String type = item[3];
				String[] info = {name, price, type};
				
				Item vend = slot.createSlot(info);
				
				
				display.put(position, vend);			
			}
			
			return display;
		}
	}
}
