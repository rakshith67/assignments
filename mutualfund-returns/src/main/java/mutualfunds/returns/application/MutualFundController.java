package mutualfunds.returns.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import mutualfunds.returns.models.MutualFundReturns;

@Controller
@Scope(value = "prototype")
public class MutualFundController implements MutualFundApi, ApplicationContextAware {

	private ApplicationContext applicationContext;

	public interface IGetMutualFundReturnsDelegate {
		ResponseEntity<List<MutualFundReturns>> getMutualFundReturns(String schemeNumber, int horizon, int period);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public ResponseEntity<List<MutualFundReturns>> getReturns(String schemeNumber, int horizon, int period) {
		IGetMutualFundReturnsDelegate mutualFundReturnsDelegate = this.applicationContext
				.getBean(MutualFundController.IGetMutualFundReturnsDelegate.class);
		return mutualFundReturnsDelegate.getMutualFundReturns(schemeNumber, horizon, period);
	}

}
