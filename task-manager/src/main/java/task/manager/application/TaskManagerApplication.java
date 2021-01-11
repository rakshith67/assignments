package task.manager.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		(new SpringApplicationBuilder(new Class[] { TaskManagerApplication.class })).build().run(args);
	}

}
