package mutualfunds.returns.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MutualFundApplication {

	public static void main(String[] args) {
		(new SpringApplicationBuilder(new Class[] { MutualFundApplication.class })).build().run(args);
	}
}
