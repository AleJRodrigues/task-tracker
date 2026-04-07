package com.Task.Tracker;

import com.Task.Tracker.Tasks.MenuTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);

		MenuTask menuTask = new MenuTask();
		menuTask.menuTask();
	}

}
