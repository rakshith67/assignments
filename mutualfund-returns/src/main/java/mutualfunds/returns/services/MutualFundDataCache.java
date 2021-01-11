package mutualfunds.returns.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import mutualfunds.returns.models.Data;

public class MutualFundDataCache {

	private NavigableMap<LocalDate, Double> cache = new TreeMap<>((date1, date2) -> {
		if (date1.isAfter(date2)) {
			return -1;
		}
		return 1;
	});

	private LocalDate currentHashedDate;

	public NavigableMap<LocalDate, Double> getCache() {
		return cache;
	}

	public LocalDate getCurrentHashedDate() {
		return currentHashedDate;
	}

	public void doHash(List<Data> dataList) {
		LocalDate temp = null;
		for (Data data : dataList) {
			if (data.getDate() != null) {
				String[] current = data.getDate().split("-");
				LocalDate date = LocalDate.of(Integer.valueOf(current[2]), Integer.valueOf(current[1]),
						Integer.valueOf(current[0]));
				if (currentHashedDate == null || date.isAfter(currentHashedDate)) {
					if (temp == null) {
						temp = date;
					}
					cache.put(date, Double.valueOf(data.getNav()));
				} else {
					break;
				}
			}
		}
		if (temp != null) {
			currentHashedDate = temp;
		}
	}
}
