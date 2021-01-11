package mutualfunds.returns.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import mutualfunds.returns.application.MutualFundController.IGetMutualFundReturnsDelegate;
import mutualfunds.returns.services.GetMutualFundReturnsDelegate;
import mutualfunds.returns.services.GetMutualFundReturnsService;
import mutualfunds.returns.services.MutualFundDataCache;

@Configuration
public class MutualFundConfig {

	@Bean
	public IGetMutualFundReturnsDelegate getMutualFundReturnsDelegate() {
		return new GetMutualFundReturnsDelegate();
	}

	@Bean
	public GetMutualFundReturnsService getMutualFundReturnsService() {
		return new GetMutualFundReturnsService();
	}

	@Bean
	public MutualFundDataCache mutualFundDataCache() {
		return new MutualFundDataCache();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
