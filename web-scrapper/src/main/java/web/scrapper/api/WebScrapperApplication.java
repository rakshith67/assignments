package web.scrapper.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebScrapperApplication {

	public static void main(String[] args) {
		(new SpringApplicationBuilder(new Class[] { WebScrapperApplication.class })).build().run(args);
	}
}