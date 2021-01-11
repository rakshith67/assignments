package web.scrapper.api;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiParam;
import web.scrapper.resources.models.ScrapperOutput;

@Controller
@Scope(value = "prototype")
public class WebScrapperApiImpl implements WebScrapperApi, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public interface IWebScrapperDelegate {
		public ResponseEntity<ScrapperOutput> execute(MultipartFile csv, MultipartFile config);
	}

	@Override
	public ResponseEntity<ScrapperOutput> webScrapper(
			@ApiParam(value = "urls to be scrapped", required = true) @Validated @RequestParam MultipartFile urls,
			@ApiParam(value = "config", required = true) @Validated @RequestParam MultipartFile config) {

		WebScrapperApiImpl.IWebScrapperDelegate delegate = this.applicationContext
				.getBean(WebScrapperApiImpl.IWebScrapperDelegate.class);

		return delegate.execute(urls, config);
	}
}
