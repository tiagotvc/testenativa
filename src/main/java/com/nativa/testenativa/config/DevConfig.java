package com.nativa.testenativa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nativa.testenativa.services.DBServices;
import com.sun.el.parser.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBServices dbService;
	
	@Value("${spring.jpa.hibernate.dll-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException{
		
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instantiateTestDatabase();
		return true;
	}

}
