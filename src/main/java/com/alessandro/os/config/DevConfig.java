package com.alessandro.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alessandro.os.services.DBService;

@Configuration
@Profile("test")
public class DevConfig {
	@Autowired
	
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")	
	private String ddl;
	
	@Bean
	public boolean instanciaDB() {
		if(ddl.equals("create-drop")) {
		this.dbService.instanciaDB();
		}
		return false;
	}
	@Bean
	public void chamaMetodoAutomatio() {
		System.out.println("DDL: "+ddl);
	}
}