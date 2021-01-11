package mutualfunds.returns.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mutualfunds.returns.application.MutualFundController.IGetMutualFundReturnsDelegate;
import mutualfunds.returns.models.MutualFundReturns;

public class GetMutualFundReturnsDelegate implements IGetMutualFundReturnsDelegate {

	@Inject
	private GetMutualFundReturnsService getMutualFundReturnsService;

	@Override
	public ResponseEntity<List<MutualFundReturns>> getMutualFundReturns(String schemeNumber, int horizon, int period) {
		if (period == 0 || horizon == 0) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		List<MutualFundReturns> returns = getMutualFundReturnsService.getMutualFundReturns(schemeNumber, horizon, period);
		return new ResponseEntity<>(returns, HttpStatus.OK);
	}

}
