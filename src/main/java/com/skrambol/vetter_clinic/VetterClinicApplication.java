package com.skrambol.vetter_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VetterClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetterClinicApplication.class, args);
	}

}
