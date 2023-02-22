package com.example.Rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("EVEN");
			} else {
				System.out.println("OUT");

			}
		}

		SpringApplication.run(RestApplication.class, args);
	}

}
