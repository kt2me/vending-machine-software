package com.techelevator.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.FileProcessor.Display;
import com.techelevator.Items.Chip;
import com.techelevator.Items.Item;

public class DisplayTest {
	
	private Display display;
	
	@Before
	public void steup() {
		display = new Display();
	}
	
	@Test
	public void displays_correct_position() throws FileNotFoundException {
		
	}
	
}
