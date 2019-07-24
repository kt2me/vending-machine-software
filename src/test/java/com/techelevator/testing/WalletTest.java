package com.techelevator.testing;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.view.Wallet;



public class WalletTest {
	
private Wallet wallet;

@Before
	public void setUp() {
	wallet = new Wallet();
}
	
@Test
	public void wallet_balance_begins_at_0() {
	BigDecimal num = wallet.getBalance();
	Assert.assertEquals(new BigDecimal(0), num);	
	}

@Test 
public void add_money_works() {
	wallet.addMoney(new BigDecimal(15));
	wallet.addMoney(new BigDecimal(15));
	BigDecimal num = wallet.getBalance();
	Assert.assertEquals(new BigDecimal(30), num);
}

@Test 
public void deduct_money_works() {
	wallet.addMoney(new BigDecimal(30));
	wallet.deductMoney(new BigDecimal(5));
	BigDecimal num = wallet.getBalance();
	Assert.assertEquals(new BigDecimal(25), num);
}


@Test 
public void empty_balance_works() {
	wallet.addMoney(new BigDecimal(30));
	wallet.emptyBalance();
	BigDecimal num = wallet.getBalance();
	Assert.assertEquals(new BigDecimal(0), num);
}

@Test 
public void make_change_works() {
	wallet.addMoney(new BigDecimal(2));
	int[] actualArray = wallet.makeChange();
	int[] expectedArray = new int[] {8,0,0};
	Assert.assertArrayEquals(expectedArray, actualArray);
}

@Test 
public void make_change_works_with_140() {
	wallet.addMoney(new BigDecimal(1.40));
	int[] actualArray = wallet.makeChange();
	int[] expectedArray = new int[] {5,1,1};
	Assert.assertArrayEquals(expectedArray, actualArray);
}


@Test 
public void make_change_works_with_355() {
	wallet.addMoney(new BigDecimal(3.55));
	int[] actualArray = wallet.makeChange();
	int[] expectedArray = new int[] {14,0,1};
	Assert.assertArrayEquals(expectedArray, actualArray);
}
}
