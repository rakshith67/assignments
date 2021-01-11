package mutualfunds.returns.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mutualfunds.returns.models.MutualFundReturns;

public interface MutualFundApi {

	@RequestMapping(value = "/mutualFund/returns", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<MutualFundReturns>> getReturns(@RequestParam String schemeNumber,
			@RequestParam int horizon, @RequestParam int period) {
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_IMPLEMENTED);
	}
}
