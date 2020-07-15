package web_scrape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Vanguard_Test {
	public static void main(String[] args) {
		final String url = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00B5B74684:GBP";
		String [] dateArray = new String [100];
		Double [] priceArray = new Double [100];
		int i = 0;
		int j = 0;
		
		try {
			final Document document = Jsoup.connect(url).maxBodySize(0).get();
			
			//System.out.println(document.outerHtml());//- Outputs all the HTML in the website
			
			//Finding the name of the stock from the title
			final String tempName = document.title();
			final String name = tempName.replace(" - FT.com", "");
			
			//Finding the date of the price, and done seperatly because it gets repeated
			for(Element rowDate: document.select("td.mod-ui-table__cell--text span")) {
				if(rowDate.select("span.mod-ui-hide-small-below").text().equals("")) {
					continue;
				} 
				else {
					final String tempDate = rowDate.select("span.mod-ui-hide-small-below").text();
					final String date = tempDate.replace("Monday, ","").replace("Tuesday, ","").replace("Wednesday, ","").replace("Thursday, ","").replace("Friday, ","");
					dateArray[i] = date;
					//System.out.println(dateArray[i]);
					i++;
					}
				
			}
			
			//Finding the price for the different days
			for (Element row : document.select("table.mod-ui-table.mod-tearsheet-historical-prices__results.mod-ui-table--freeze-pane tr")) { //Created a for each loop, which loops through elements in an array 
				//for (type variableName : arrayName)
				
				if(row.select("td.mod-ui-table__cell--text").text().equals("")) {
					continue;
				}
				else {
					final String date1 = row.select("td.mod-ui-table__cell--text").text();
					//final String name = row.select("td.name:nth-of-type(2)").text();
					final String tempPrice = row.select("td:nth-of-type(2)").text();
					final String edittempPrice = tempPrice.replace(",","");
					final double price = Double.parseDouble(edittempPrice);
					priceArray[j] = price;
					//System.out.println(priceArray[j]);
					j++;
				}
			}
			
			//Finally printing it all out
			for(int k = 0; k < 25; k++) {
				System.out.println(dateArray[k] + " " + priceArray[k]);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
