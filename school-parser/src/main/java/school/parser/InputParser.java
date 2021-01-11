package school.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class InputParser {

	public static  List<School> parseInput(String csvFile) {
		FileReader fileReader = null;
		CSVReader csvReader = null;
		try {
			fileReader = new FileReader(csvFile);

			csvReader = new CSVReader(fileReader);

			String[] nextRecord;
			List<School> list = new ArrayList();

			while ((nextRecord = csvReader.readNext()) != null) {
				int count = 0;
				School school = new School();
				for (String cell : nextRecord) {
					if (count == 0) {
						school.setId(cell);
					} else if (count == 1) {
						school.setLeaId(cell);
					} else if (count == 2) {
						school.setService(cell);
					} else if (count == 3) {
						school.setName(cell);
					} else if (count == 4) {
						school.setCity(cell);
					} else if (count == 5) {
						school.setState(cell);
					} else if (count == 6) {
						school.setLattit(cell);
					} else if (count == 7) {
						school.setLongitude(cell);
					} else if (count == 8) {
						school.setmLocale(cell);
					} else if (count == 9) {
						school.setuLocale(cell);
					} else if (count == 10) {
						school.setStatue(cell);
					}
					count++;
				}
				list.add(school);
			}
			return list;
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
		return null;
	}
}
