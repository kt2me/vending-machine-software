package com.techelevator.FileProcessor;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class SalesReportReader {
	
	File file = new File("log.txt");

Map <String, String> salesItems = new LinkedHashMap<String, String>();
	
public Map <String, String> createSalesReport() throws FileNotFoundException {

	try(Scanner fileScanner = new Scanner(file)){
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine().trim();
			String[] items = line.split("|");
			if (!(items[3].equals("FEED") && !(items[3].equals("GIVE")))){
				salesItems.put(items[3],items[4]);
			}
		}
	
	}
	return salesItems;
	}
}