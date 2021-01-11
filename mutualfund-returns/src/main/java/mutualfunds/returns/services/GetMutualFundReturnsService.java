package mutualfunds.returns.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import mutualfunds.returns.models.MutualFund;
import mutualfunds.returns.models.MutualFundReturns;
import mutualfunds.returns.models.TimePeriod;

public class GetMutualFundReturnsService {

	@Inject
	private RestTemplate restTemplate;

	@Inject
	private MutualFundDataCache mutualFundDataCache;

	public List<MutualFundReturns> getMutualFundReturns(String schemeNumber, int horizon, int period) {
		if (requiredToCallApi(LocalDate.now())) {
			MutualFund mutualFund = getMutualFundData(schemeNumber);
			mutualFundDataCache.doHash(mutualFund.getData());
		}
		return applyFilters(horizon, period);
	}

	private boolean requiredToCallApi(LocalDate now) {
		if(mutualFundDataCache.getCurrentHashedDate() == null) {
			return true;
		}
		return now.isAfter(mutualFundDataCache.getCurrentHashedDate());
	}

	private MutualFund getMutualFundData(String schemeNumber) {
		String hostAddress = "https://api.mfapi.in/mf/" + schemeNumber;
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		headers.add(HttpHeaders.ACCEPT, "*/*");
		headers.add("Connection", "keep-alive");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<MutualFund> mutualFundData = null;
		try {
			mutualFundData = restTemplate.exchange(hostAddress, HttpMethod.GET, requestEntity, MutualFund.class);
		} catch (Exception e) {
			return new MutualFund();
		}
		return mutualFundData.getBody();
	}

	private List<MutualFundReturns> applyFilters(int horizon, int period) {
		NavigableMap<LocalDate, Double> map = mutualFundDataCache.getCache();
		int totalMonths = horizon * 12;
		List<MutualFundReturns> list = new ArrayList<>();
		for (LocalDate date : map.keySet()) {
			LocalDate previous = date.minus(period, ChronoUnit.YEARS);
			MutualFundReturns returns = new MutualFundReturns();
			double profitPercentage = map.ceilingEntry(date).getValue() / map.ceilingEntry(previous).getValue();
			double totalReturnPercentage = (Math.pow(profitPercentage, 1 / period) - 1) * 100;
			returns.setReturns(totalReturnPercentage);
			returns.setMonth(date);
			TimePeriod timePeriod = new TimePeriod();
			timePeriod.setStart(previous);
			timePeriod.setEnd(date);
			returns.setPeriod(timePeriod);
			list.add(returns);
			totalMonths--;
			if (totalMonths == 0) {
				break;
			}
		}
		return list;
	}

}
