package web.scrapper.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.scrapper.resources.models.ScrapperOutput;

public class ScrapperOutputPrinter {

	private ObjectMapper mapper = null;

	public ScrapperOutputPrinter() {
		if (null == mapper) {
			mapper = new ObjectMapper();
		}
	}

	/**
	 * Prints the output in the console.
	 */
	public void printOutput(ScrapperOutput output) {
		if (output == null) {
			System.out.println("No data");
			return;
		}
		try {
			System.out.println(mapper.writeValueAsString(output.getData()));
		} catch (JsonProcessingException e) {
		}
	}
}
