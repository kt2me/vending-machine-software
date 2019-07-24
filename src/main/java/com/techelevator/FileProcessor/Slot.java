package com.techelevator.FileProcessor;

import com.techelevator.Items.Candy;
import com.techelevator.Items.Chip;
import com.techelevator.Items.Drink;
import com.techelevator.Items.Gum;
import com.techelevator.Items.Item;

public class Slot {

	
	public Item createSlot(String[] info) {
		
		if(info[2].equalsIgnoreCase("chip")) {
			Chip chip = new Chip(info[0],info[1]);
			return chip;
		}else if(info[2].equalsIgnoreCase("drink")) {
			Drink drink = new Drink(info[0],info[1]);
			return drink;
		}else if(info[2].equalsIgnoreCase("candy")) {
			Candy candy = new Candy(info[0],info[1]);
			return candy;
		}else if(info[2].equalsIgnoreCase("gum")) {
			Gum gum = new Gum(info[0],info[1]);
			return gum;
		}
		
		
		return null;
	}
	
}
