//LEARNINGS
//final - once assigned to a variable, it always contains the same value

package web_scrape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; //A HTML element consists of a tag name, attributes, and child nodes (including text nodes and other elements). 
								//From an Element, you can extract data, traverse the node graph, and manipulate the HTML. 

public class web_scrape {
	public static void main(String[] args) {
		final String url = "https://www.londonstockexchange.com/exchange/prices-and-markets/stocks/indices/summary/summary-indices-constituents.html?index=UKX";
		
		try {
			final Document document = Jsoup.connect(url).get();
			
			//System.out.println(document.outerHtml()); //- Outputs all the HTML in the website
			for (Element row : document.select("table.table_dati tr")) { //Created a for each loop, which loops through elements in an array 
				//for (type variableName : arrayName)
				
				if(row.select("td.name:nth-of-type(1)").text().equals("")) {
					continue;
				}
				else {
					final String ticker = row.select("td.name:nth-of-type(1)").text();
					final String name = row.select("td.name:nth-of-type(2)").text();
					final String tempPrice = row.select("td:nth-of-type(4)").text();
					final String edittempPrice = tempPrice.replace(",","");
					final double price = Double.parseDouble(edittempPrice);
							System.out.println(row + "|");
				}
				
			}
			
			for(Element links : document.select("a")) {//<a> tag defines a hyperlink, and the href attribute which indicates the link's destination
				//System.out.println(links.attr("abs:href"));
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
