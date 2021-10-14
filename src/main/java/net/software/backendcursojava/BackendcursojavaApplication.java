package net.software.backendcursojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendcursojavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendcursojavaApplication.class, args);

		System.out.println("Probando las extensiones...");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
