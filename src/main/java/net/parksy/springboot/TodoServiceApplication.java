package net.parksy.springboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import net.parksy.springboot.model.Todo;
import net.parksy.springboot.service.JsonPlaceHolderService;
import net.parksy.springboot.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Darryl's Reference Spring Boot Application",
//		version = "1.0", description = "TODO Application Plus"))
public class TodoServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner commandLineRunner(JsonPlaceHolderService placeHolderService, TodoService todoService) {
		return args -> {
			// when the application loads get the 200 todos from JsonPlaceholder
			List<Todo> todos = placeHolderService.getTodos();
			todoService.saveAll(todos);
			log.info("Saved {} todos in the database", todos.size());
		};
	}
}
