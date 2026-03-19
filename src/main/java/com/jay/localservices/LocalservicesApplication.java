package com.jay.localservices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LocalservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalservicesApplication.class, args);
	}
}