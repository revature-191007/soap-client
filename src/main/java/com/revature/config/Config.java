package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.revature.clients.SuperHeroClient;

@Configuration
public class Config {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.revature.models.generated");
		return marshaller;
	}
	
	@Bean
	public SuperHeroClient superHeroClient(Jaxb2Marshaller marshaller) {
		SuperHeroClient client = new SuperHeroClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
