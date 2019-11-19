package com.revature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.clients.SuperHeroClient;
import com.revature.models.generated.GetHeroResponse;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(SuperHeroClient client) {
		return args -> {
			String name = "The Hulk";
			System.err.println(name);
			
			GetHeroResponse response = client.getHero(name);
			System.out.println(response.getSuperHero().getSuperPower());
		};
	}
}
