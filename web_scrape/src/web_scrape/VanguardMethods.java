package web_scrape;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class VanguardMethods {
	
	//Getting todays price
	public static Double TodaysPrice (String url) {
		Double Price = null;
		Double [] priceArray = new Double [100];
		int j = 0;
		
		try {
			Document document;
			document = Jsoup.connect(url).maxBodySize(0).get();
		
			for (Element row : document.select("table.mod-ui-table.mod-tearsheet-historical-prices__results.mod-ui-table--freeze-pane tr")) { //Created a for each loop, which loops through elements in an array 
			//for (type variableName : arrayName)
			
				if(row.select("td.mod-ui-table__cell--text").text().equals("")) {
					continue;
				}
				else {
					final String tempPrice = row.select("td:nth-of-type(5)").text();
					final String edittempPrice = tempPrice.replace(",","");
					final double price = Double.parseDouble(edittempPrice);
					priceArray[j] = price;
					//System.out.println(priceArray[j]);
					j++;
				}
			}
			Price = priceArray[0];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Price;
	}
	
	public static Double Price2 (String url) {
		Double Price = null;
		Double [] priceArray = new Double [100];
		int j = 0;
		
		try {
			Document document;
			document = Jsoup.connect(url).maxBodySize(0).get();
		
			for (Element row : document.select("table.mod-ui-table.mod-tearsheet-historical-prices__results.mod-ui-table--freeze-pane tr")) { //Created a for each loop, which loops through elements in an array 
			//for (type variableName : arrayName)
			
				if(row.select("td.mod-ui-table__cell--text").text().equals("")) {
					continue;
				}
				else {
					final String tempPrice = row.select("td:nth-of-type(5)").text();
					final String edittempPrice = tempPrice.replace(",","");
					final double price = Double.parseDouble(edittempPrice);
					priceArray[j] = price;
					//System.out.println(priceArray[j]);
					j++;
				}
			}
			Price = priceArray[1];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Price;
	}
	
	public static Double Price3 (String url) {
		Double Price = null;
		Double [] priceArray = new Double [100];
		int j = 0;
		
		try {
			Document document;
			document = Jsoup.connect(url).maxBodySize(0).get();
		
			for (Element row : document.select("table.mod-ui-table.mod-tearsheet-historical-prices__results.mod-ui-table--freeze-pane tr")) { //Created a for each loop, which loops through elements in an array 
			//for (type variableName : arrayName)
			
				if(row.select("td.mod-ui-table__cell--text").text().equals("")) {
					continue;
				}
				else {
					final String tempPrice = row.select("td:nth-of-type(5)").text();
					final String edittempPrice = tempPrice.replace(",","");
					final double price = Double.parseDouble(edittempPrice);
					priceArray[j] = price;
					//System.out.println(priceArray[j]);
					j++;
				}
			}
			Price = priceArray[2];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Price;
	}
	
	//Getting todays date for the corresponding price
	public static String TodaysPriceDate (String url){
		String Date = "";
		String [] dateArray = new String [100];
		int i = 0;
		
		Document document;
		try {
			document = Jsoup.connect(url).maxBodySize(0).get();

		
			for(Element rowDate: document.select("td.mod-ui-table__cell--text span")) {
				if(rowDate.select("span.mod-ui-hide-small-below").text().equals("")) {
					continue;
				} 
				else {
					final String tempDate = rowDate.select("span.mod-ui-hide-small-below").text();
					final String dateWithoutQuotes = tempDate.replace("Monday, ","").replace("Tuesday, ","").replace("Wednesday, ","").replace("Thursday, ","").replace("Friday, ","");
					String dateList = "\"" + dateWithoutQuotes + "\"";
					dateArray[i] = dateList;
					//System.out.println(dateArray[i]);
					i++;
					}
			
			}
			Date = dateArray[0];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Date;
	}
	
	public static String Date2 (String url){
		String Date = "";
		String [] dateArray = new String [100];
		int i = 0;
		
		Document document;
		try {
			document = Jsoup.connect(url).maxBodySize(0).get();

		
			for(Element rowDate: document.select("td.mod-ui-table__cell--text span")) {
				if(rowDate.select("span.mod-ui-hide-small-below").text().equals("")) {
					continue;
				} 
				else {
					final String tempDate = rowDate.select("span.mod-ui-hide-small-below").text();
					final String dateWithoutQuotes = tempDate.replace("Monday, ","").replace("Tuesday, ","").replace("Wednesday, ","").replace("Thursday, ","").replace("Friday, ","");
					String dateList = "\"" + dateWithoutQuotes + "\"";
					dateArray[i] = dateList;
					//System.out.println(dateArray[i]);
					i++;
					}
			
			}
			Date = dateArray[1];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Date;
	}
	
	public static String Date3 (String url){
		String Date = "";
		String [] dateArray = new String [100];
		int i = 0;
		
		Document document;
		try {
			document = Jsoup.connect(url).maxBodySize(0).get();

		
			for(Element rowDate: document.select("td.mod-ui-table__cell--text span")) {
				if(rowDate.select("span.mod-ui-hide-small-below").text().equals("")) {
					continue;
				} 
				else {
					final String tempDate = rowDate.select("span.mod-ui-hide-small-below").text();
					final String dateWithoutQuotes = tempDate.replace("Monday, ","").replace("Tuesday, ","").replace("Wednesday, ","").replace("Thursday, ","").replace("Friday, ","");
					String dateList = "\"" + dateWithoutQuotes + "\"";
					dateArray[i] = dateList;
					//System.out.println(dateArray[i]);
					i++;
					}
			
			}
			Date = dateArray[2];
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Date;
	}
	
	//Finding the name of the stock from the title
	public static String InvestmentName (String url) {
		Document document;
		String name = "";
		String nameWithoutQuotes = "";
		
		try {
			document = Jsoup.connect(url).maxBodySize(0).get();
			final String tempName = document.title();
			nameWithoutQuotes = tempName.replace(" - FT.com", "");
			name = "\"" + nameWithoutQuotes + "\"";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}
	
	public static void WriteToExcel(Double[] priceArray, Double[] price2Array, Double[] price3Array, String[] dateArray, String[] date2Array, String[] date3Array, String[] nameArray, int arrayLength) {
		//Setting the date for the file
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM_HHmm_");
		Date formatDate = new Date();
		String date = formatter.format(formatDate);
		
		try {
			FileWriter fos = new FileWriter("C:\\Users\\chris\\Google Drive\\PC_Stuff\\Programing\\Git\\Financial_WebScrape\\web_scrape\\files\\" + date + "Vanguard.csv", true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println("Investment Name, Dates1, Prices1, Dates2, Prices2, Dates3, Prices3"); 
			
			for(int i = 0; i < arrayLength; i++) {
				if(i == 8) {
					pw.println("-");
				}
				pw.println(nameArray[i] + "," + dateArray[i] + "," + priceArray[i] + "," + date2Array[i] + "," + price2Array[i] + "," + date3Array[i] + "," + price3Array[i]);
			}
			
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				System.out.println("Data Written to Excel file: " + date + "Vanguard.csv");
	}

}
