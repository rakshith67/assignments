package school.parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

	// run using the param -DfileName=<csv file>
	// for search -Dcity=<cityName>,-Dstate=<stateName>,-Dname=<name>
	public static void main(String[] args) {
		String fileName = System.getProperty("fileName");
		List<School> schools = InputParser.parseInput(fileName);
		
		Set<School> schoolSet = new HashSet();
		for(School school: schools) {
			schoolSet.add(school);
		}

		System.out.println("Total schools " + schools.size());

		Map<String, Integer> schoolsByStateCount = new HashMap<String, Integer>();
		for (School school : schools) {
			schoolsByStateCount.put(school.getState(),
					schoolsByStateCount.get(schoolsByStateCount.getOrDefault(school.getState(), 0) + 1));
		}
		System.out.println("Schools by state:");
		for (Map.Entry<String, Integer> entry : schoolsByStateCount.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		int max = 0;
		String city = null;
		Map<String, Integer> schoolsByCityCount = new HashMap<String, Integer>();
		for (School school : schools) {
			schoolsByCityCount.put(school.getState(),
					schoolsByCityCount.get(schoolsByCityCount.getOrDefault(school.getState(), 0) + 1));
			if (max < schoolsByCityCount.get(school.getCity())) {
				city = school.getCity();
			}
		}
		System.out.println("Max schools in city " + city);

		System.out.println(schoolsByCityCount.size() + " has at least one city, They are: ");
		for (String key : schoolsByCityCount.keySet()) {
			System.out.println(key);
		}

		Map<String, Set<School>> schoolsByName = new HashMap<String, Set<School>>();
		for (School school : schools) {
			if (schoolsByName.containsKey(school.getName())) {
				Set<School> list = schoolsByName.get(school.getName());
				list.add(school);
				continue;
			}
			Set<School> list = new HashSet();
			list.add(school);
			schoolsByName.put(school.getName(), list);
		}

		Map<String, Set<School>> schoolsByCity = new HashMap<String, Set<School>>();
		for (School school : schools) {
			if (schoolsByCity.containsKey(school.getCity())) {
				Set<School> list = schoolsByCity.get(school.getCity());
				list.add(school);
				continue;
			}
			Set<School> list = new HashSet();
			list.add(school);
			schoolsByCity.put(school.getCity(), list);
		}

		Map<String, Set<School>> schoolsByState = new HashMap<String, Set<School>>();
		for (School school : schools) {
			if (schoolsByState.containsKey(school.getState())) {
				Set<School> list = schoolsByState.get(school.getState());
				list.add(school);
				continue;
			}
			Set<School> list = new HashSet();
			list.add(school);
			schoolsByState.put(school.getState(), list);
		}

		searchByCityStateName(schoolSet, schoolsByName, schoolsByCity, schoolsByState);
	}

	private static void searchByCityStateName(Set<School> schools, Map<String, Set<School>> schoolsByName,
			Map<String, Set<School>> schoolsByCity, Map<String, Set<School>> schoolsByState) {
		String name = System.getProperty("name");
		String city = System.getProperty("city");
		String state = System.getProperty("state");
		List<School> result = new LinkedList();
		Set<School> schoolsByNameList = schoolsByName.getOrDefault(name, schools);
		Set<School> schoolsByCityList = schoolsByCity.getOrDefault(city, schools);
		Set<School> schoolsByStateList = schoolsByState.getOrDefault(state, schools);
		
		for(School school: schoolsByNameList) {
			if(schoolsByCityList.contains(school) && schoolsByStateList.contains(school)) {
				result.add(school);
			}
		}
		
		System.out.println("Schools with given filters");
		for(School school: result) {
			System.out.println(school.getName());
		}
		
		
	}
}
