package com.example.__Message_Service_Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private Notification notification;

	public Application() {
	}

	public Application(Notification notification) {
		this.notification = notification;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args){
		notification.notifyUser();
	}

}
