package com.techelevator.Items;

public class Chip extends Item{

	public Chip(String name, String price) {
		super(name, price);
	}
	
	public String reaction() {
		return "Crunch Crunch, Yum!";
	}
	
	@Override
	public String toString() {
		return "Chip";
	}
}
