package com.techelevator.FileProcessor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogOutput {
	File logFile = new File("log.txt");

	public void logTransaction(String transactionLog) throws IOException{
		try (FileWriter writer = new FileWriter(logFile, true)) {
			writer.write(String.format(transactionLog));
			writer.write(System.lineSeparator());
		}

	}
}
