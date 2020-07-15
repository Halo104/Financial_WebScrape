package web_scrape;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportToExcel {
	public static void main(String[] args) {
		
		  try {
		  
		  FileWriter fos = new FileWriter("C:\\Users\\chris\\Google Drive\\PC Stuff\\Programing\\Eclips_Java\\web_scrape\\files\\people.csv", true); 
		  //Used for writing raw bytes such as image data. For writing streams of characters, consider using FileWriter 
		  //FileWriter is meant for writing streams of characters. For writing streams of raw bytes, consider using a FileOutputStream. 
		  PrintWriter pw = new PrintWriter(fos); //Prints formatted representations of objects to a text-output stream. This class implements all of the print methods found in PrintStream. 
		  //It does not contain methods for writing raw bytes, for which a program should use unencoded byte streams
		  
		  pw.println("Name, Age, Weight"); 
		  pw.println("Bob, 24, 175");
		  pw.println("Carol, 36, 120"); 
		  pw.close();
		  
		  System.out.println("file people.csv has been written");
		  
		  } catch (FileNotFoundException e) { 
			  // TODO Auto-generated catch block
			  e.printStackTrace(); 
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	}

	private static void WriteToExcel(Double[] PriceArray, String[] DateArray, int ArrayLength) {
		//Setting the date for the file
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM_HHmm_");
		Date formatDate = new Date();
		String date = formatter.format(formatDate);
		
		try {
			FileWriter fos = new FileWriter("C:\\Users\\chris\\Google Drive\\PC_Stuff\\Programing\\Eclips_Java\\web_scrape\\files\\" + date + "Vanguard.csv", true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println("Name, Age, Weight"); 
			pw.println("Bob, 24, 175");
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ArrayLength);
	}

}
