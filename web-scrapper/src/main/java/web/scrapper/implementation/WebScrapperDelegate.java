package web.scrapper.implementation;

import web.scrapper.resources.models.ScrapperInput;
import web.scrapper.resources.models.ScrapperOutput;

public class WebScrapperDelegate {

	WebScrapperController controller = new WebScrapperController();
	ScrapperOutputPrinter printer = new ScrapperOutputPrinter();

	/**
	 * Function: Getting the input and output and printing output.
	 */
	public void execute(String csv, String config) {
		ScrapperInput input = new InputParser().parseInput(csv, config);
		ScrapperOutput output = controller.extractData(input);
		printer.printOutput(output);
	}

}
