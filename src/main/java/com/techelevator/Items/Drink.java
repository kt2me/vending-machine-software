package com.techelevator.Items;

public class Drink extends Item{

	public Drink(String name, String price) {
		super(name, price);
	}
	
	public String reaction() {
		return "Glug Glug, Yum!";
	}
	
	@Override
	public String toString() {
		return "Drink";
	}
}
