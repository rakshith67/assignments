package web.scrapper.resources.models;

import com.opencsv.bean.CsvBindByName;

public class Url {

	@CsvBindByName
	private String url;

	public Url(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
