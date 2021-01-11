package web.scrapper.resources.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScrapperOutput {

	List<Map<String, Object>> data = new ArrayList<>();

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
