package web_scrape;

public class ToRunMethods {
	public static void main(String[] args) {
		String dateA = "";
		
		String url = "https://markets.ft.com/data/funds/tearsheet/historical?s=GB00BD3RZ251:GBP";
		dateA = VanguardMethods.Date3(url);
		
		System.out.println(dateA);
	}
}
