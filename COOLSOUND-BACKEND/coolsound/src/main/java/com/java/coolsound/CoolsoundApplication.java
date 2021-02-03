package com.java.coolsound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import com.java.coolsound.model.Usuario;

@SpringBootApplication
public class CoolsoundApplication {
	
	public interface categoriasRepository extends CrudRepository<Usuario, Integer> {

	}

	public static void main(String[] args) {
		SpringApplication.run(CoolsoundApplication.class, args);
	}

}
