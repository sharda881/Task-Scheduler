package com.alpha.task_scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulerApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return args -> {
			Task task = new Task();
			task.setTitle("Test PostgreSQL Task");
			repository.save(task);
			System.out.println("✅ Task saved to database!");
		};
	}

}
