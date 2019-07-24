package com.techelevator.Items;

import java.math.BigDecimal;

public class Item {
	
	int stock = 5;
	private String name;
	private String price;
	
	public Item(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public String reaction() {
		return "";
	}

	public BigDecimal getPrice() {
		BigDecimal converted = new BigDecimal(price);
		return converted;
	}
	
//	private int convertPriceStringToInt() {
//		String convert = price;
//		int converted = (int)Integer.parseInt(convert); 
//		return converted;
//	}
	
	public int getStock() {
		return stock;
	}
	
	public void removeItem() {
		stock--;
	}
	
	public String getType() {
		return this.toString();
	}
}
