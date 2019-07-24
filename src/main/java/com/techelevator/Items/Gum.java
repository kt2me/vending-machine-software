package com.techelevator.Items;

public class Gum extends Item{

	public Gum(String name, String price) {
		super(name, price);
	}
	
	public String reaction() {
		return "Chew Chew, Yum!";
	}
	
	@Override
	public String toString() {
		return "Gum";
	}
}
