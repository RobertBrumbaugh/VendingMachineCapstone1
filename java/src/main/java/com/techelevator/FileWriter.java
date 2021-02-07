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

//	public static void main(String[] args) {
//		try {
//			File fileWriter = new File("log.txt");
//			if (fileWriter.createNewFile()){
//				System.out.println("File Created:" + fileWriter.getName());
//			} else {
//				System.out.println("File Already Exists!");
//			}
//		}catch(IOException ex) {
//			System.out.println("An Error Occured.");
//		}
//	}
//}
//
//	
//	try {
//		FileWriter fileWriter = new FileWriter("log.txt");
//		fileWriter.write("Insert Info Here");
//		fileWriter.close();
//		System.out.println("Write To Log Successful!");
//	}catch 9IO Exception ex){
//		System.out.println("Could Not Write To File");
//	}
//}
//}
}



