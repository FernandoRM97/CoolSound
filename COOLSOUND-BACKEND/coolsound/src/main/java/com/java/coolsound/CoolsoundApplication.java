package com.java.coolsound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.coolsound.service.CorreoService;
import com.java.coolsound.service.CorreoServiceImpl;

@SpringBootApplication
public class CoolsoundApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CoolsoundApplication.class, args);
		
	}

}
