package com.alessandro.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alessandro.os.services.DBService;

@Configuration
@Profile("dev")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
	
	public void chamaMetodoAutomatio() {
		System.out.println("Fui chamado pelo BEAN");
	}
}