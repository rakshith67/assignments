package web.scrapper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import web.scrapper.api.WebScrapperApiImpl.IWebScrapperDelegate;
import web.scrapper.implementation.WebScrapperDelegate;

@ConfigurationProperties
public class Config {

	@Bean
	public IWebScrapperDelegate webScrapperDelegate() {
		return new WebScrapperDelegate();
	}
}
