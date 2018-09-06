package com.spring.mvc.SrpingMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SrpingMvcApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		SpringApplication.run(SrpingMvcApplication.class, args);
		System.out.println(encoder.encode("12345678"));
		//System.out.println("Application started ...");
	}
}
