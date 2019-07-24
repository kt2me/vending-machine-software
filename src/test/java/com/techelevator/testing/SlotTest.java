package com.techelevator.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.FileProcessor.Slot;
import com.techelevator.Items.Chip;
import com.techelevator.Items.Gum;
import com.techelevator.Items.Item;

public class SlotTest {
	
	private Slot slot;
	
	@Before
	public void setup() {
		slot = new Slot();
	}
	
	@Test
	public void confirm_correct_item_created() {
		String[] test = {"dorito", "7", "Chip"};
		Item vend = slot.createSlot(test);
		boolean verify = (vend instanceof Chip);
		
		Assert.assertTrue(verify);
		
		test[0] = "Five Gum";
		test[1] = "2";
		test[2] = "Gum";
		vend = slot.createSlot(test);
		verify = (vend instanceof Gum);
		
		Assert.assertTrue(verify);
	}
	
	@Test
	public void item_has_proper_name() {
		String[] test = {"dorito", "7", "Chip"};
		Item vend = slot.createSlot(test);
		
		Assert.assertEquals("dorito", vend.getName());
	}
	
	@Test
	public void item_has_proper_price() {
		String[] test = {"dorito", "7", "Chip"};
		Item vend = slot.createSlot(test);
		//Integer seven = 7;
		
		Assert.assertEquals(7, vend.getPrice());
	}
	
}
