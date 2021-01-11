package web.scrapper.implementation;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import web.scrapper.resources.models.Entity;
import web.scrapper.resources.models.ScrapperInput;
import web.scrapper.resources.models.Url;

public class InputParser {

	/**
	 * Parses the input csvFile and config.json file and converts them to list of
	 * urls and entity.
	 */
	@SuppressWarnings({ "resource" })
	public ScrapperInput parseInput(String csvFile, String config) {

		ScrapperInput input = new ScrapperInput();

		FileReader fileReader = null;
		CSVReader csvReader = null;
		try {
			fileReader = new FileReader(csvFile);

			csvReader = new CSVReader(fileReader);
			String[] nextRecord;
			List<Url> list = new ArrayList<>();

			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					list.add(new Url(cell));
				}
			}
			input.setUrls(list);
		} catch (Exception e1) {
			System.out.println("Failed parsing CSV because of " + e1.getLocalizedMessage());
		} finally {
			try {
				if (null != fileReader) {
					fileReader.close();
				}
				if (null != csvReader) {
					csvReader.close();
				}
			} catch (IOException e) {
				System.out.println("Failed parsing CSV because of " + e.getLocalizedMessage());
			}
		}

		Entity entity = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = new String(Files.readAllBytes(Paths.get(config)), StandardCharsets.UTF_8);
			entity = mapper.readValue(jsonString, new TypeReference<Entity>() {
			});
			input.setEntity(entity);
		} catch (Exception e) {
			System.out.println("Failed parsing JSON because of " + e.getLocalizedMessage());
		}

		return input;
	}
}
