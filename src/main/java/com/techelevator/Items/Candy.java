package com.techelevator.Items;

public class Candy extends Item{

	public Candy(String name, String price) {
		super(name, price);
	}
	
	public String reaction() {
		return "Munch Munch, Yum!";
	}
	
	@Override
	public String toString() {
		return "Candy";
	}
}
