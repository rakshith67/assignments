package web.scrapper;

import web.scrapper.implementation.WebScrapperDelegate;

public class WebScrapperApp {

	public static void main(String[] args) {
		new WebScrapperDelegate().execute(System.getProperty("csv", "urls.csv"),
				System.getProperty("config", "config.json"));
	}
}
