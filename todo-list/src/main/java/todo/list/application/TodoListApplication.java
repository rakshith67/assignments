package todo.list.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import todo.list.repository.TodoListRepository;
import todo.list.services.TodoListService;

public class TodoListApplication extends Application<Configuration> {

	private static final Logger LOGGER = LoggerFactory.getLogger(TodoListApplication.class);

	@Override
	public void initialize(Bootstrap<Configuration> b) {
	}

	@Override
	public void run(Configuration c, Environment e) throws Exception {
		TodoListRepository repository = new TodoListRepository();
		TodoListService service = new TodoListService(repository);
		LOGGER.info("Registering REST resources");
		e.jersey().register(new TodoListRestController(service));
		e.jersey().register(new TodoListExceptionMapper());
	}

	public static void main(String[] args) throws Exception {
		new TodoListApplication().run(args);
	}
}
