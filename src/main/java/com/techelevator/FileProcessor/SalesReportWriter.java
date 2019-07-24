package com.techelevator.FileProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class SalesReportWriter {
	
SalesReportReader reader = new SalesReportReader();
File salesReportFile = new File("SalesReport.txt");

public void salesReportWriter() throws IOException {
Map <String, String> listOfSales = reader.createSalesReport();
for (Map.Entry<String, String>item : listOfSales.entrySet()) {
	String itemPurchased = item.getKey();
	String purchasePrice = item.getValue();
	try (FileWriter salesReport = new FileWriter(salesReportFile, true)){
		salesReport.write(String.format(itemPurchased + purchasePrice));
		salesReport.write(System.lineSeparator());
	}
}
}

}
