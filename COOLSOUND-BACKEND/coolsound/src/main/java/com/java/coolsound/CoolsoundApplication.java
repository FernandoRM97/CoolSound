package com.java.coolsound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CoolsoundApplication{

//	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CoolsoundApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Path path = Paths.get("src/main/resources/import.sql");
//		
//		Log log = LogFactory.getLog(getClass());
//		
//		try(BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
//			String line;
//			while((line = bufferedReader.readLine()) != null) {
//				jdbcTemplate.execute(line);
//			}
//		} catch (IOException ex) {
//		}
//	}

}
