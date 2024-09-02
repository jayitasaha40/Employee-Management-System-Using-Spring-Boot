package com.coding.jayita.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiLearnApplication implements CommandLineRunner
{
	@Autowired
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(RestApiLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(db.getData());
	}

}
