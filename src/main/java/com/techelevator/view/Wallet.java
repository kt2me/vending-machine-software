package com.techelevator.view;

import java.awt.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
private BigDecimal balance = new BigDecimal(0);

public Wallet () {
	
}

public void addMoney(BigDecimal amount) {
	balance = balance.add(amount);
}

public void deductMoney(BigDecimal amount) {
	balance = balance.subtract(amount);
}

public BigDecimal getBalance() {
	return balance;
}

public void emptyBalance() {
	balance = new BigDecimal(0);
}

public int[] makeChange() {
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	
	BigDecimal decimalAmount = getBalance().multiply(new BigDecimal(100));
	decimalAmount = decimalAmount.setScale(0, RoundingMode.HALF_UP);
	int currentAmount = Integer.valueOf(decimalAmount.intValueExact());

	
	quarters = currentAmount / 25;
	currentAmount -= (quarters *25);
	if (currentAmount>0) {
	dimes = currentAmount /10;
	currentAmount -= (dimes*10);
	} if (currentAmount>=0)
	nickels = currentAmount/5;
	currentAmount -= (nickels*5);
	
	int[] change = new int[]{quarters, dimes, nickels};
	return change;

}
	
}


