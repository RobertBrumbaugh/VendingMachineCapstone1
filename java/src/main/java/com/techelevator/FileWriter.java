package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWriter {
	
		public void logWriter(String message) throws IOException{
			
			File logFile = new File("log.txt");
			
			LocalDateTime newTimeStamp = LocalDateTime.now();
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
			
			boolean appendMode = logFile.exists() ? true : false;
			
			try(PrintWriter printLogFile = new PrintWriter(new FileOutputStream(logFile, appendMode))){
				printLogFile.append(dateTime.format(newTimeStamp) + " " + message);
			}
		}
}



