package web_scrape;

import java.util.Arrays;

public class Vangaurd_UpperLevel {
	public static void main(String[] args) {
		String [] url = new String [20];
		Arrays.fill(url, "");
		Double [] priceArray = new Double [100];
		Double [] price2Array = new Double [100];
		Double [] price3Array = new Double [100];
		String [] dateArray = new String [100];
		String [] date2Array = new String [100];
		String [] date3Array = new String [100];
		String [] nameArray = new String [100];
		int urlCount = 0;
		
		//Equity
		url [0] = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00BD3RZ251:GBP";
		url [1] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VUKE:LSE:GBP";
		url [2] = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00B5B74684:GBP";
		url [3] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VUSA:LSE:GBP";
		url [4] = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00B5B74S01:GBP";
		url [5] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VAPX:LSE:GBP";
		url [6] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VMVL:LSE:GBP";
		url [7] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VFEM:LSE:GBP";
		//Bonds
		url [8] = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00B44DQC62:GBP";
		url [9] = "https://markets.ft.com/data/funds/tearsheet/historical?s=IE00B1S74W91:GBP";
		url [10] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VUTY:LSE:GBP";
		url [11] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VUSC:LSE:GBP";
		url [12] = "https://markets.ft.com/data/etfs/tearsheet/historical?s=VUCP:LSE:GBP";
		
		for (int i = 0; i < url.length; i++) {
			if(url[i] == "") {
				continue;
			}
			else {
				priceArray[i] = VanguardMethods.TodaysPrice(url[i]);
				price2Array[i] = VanguardMethods.Price2(url[i]);
				price3Array[i] = VanguardMethods.Price3(url[i]);
				dateArray[i] = VanguardMethods.TodaysPriceDate(url[i]);
				date2Array[i] = VanguardMethods.Date2(url[i]);
				date3Array[i] = VanguardMethods.Date3(url[i]);
				nameArray[i] = VanguardMethods.InvestmentName(url[i]);
				System.out.println(priceArray[i] + dateArray[i] + nameArray[i]);
				urlCount++;
			}
			
		}
		VanguardMethods.WriteToExcel(priceArray, price2Array, price3Array, dateArray, date2Array, date3Array, nameArray, urlCount);
	}
	
}
