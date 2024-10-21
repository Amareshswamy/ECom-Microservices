package com.project.microservice.inventroy;

import org.springframework.boot.SpringApplication;

public class TestInventroyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventroyServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
