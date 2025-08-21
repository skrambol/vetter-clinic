package com.skrambol.vetter_clinic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Config
 */
@Configuration
@EnableWebSecurity(debug = true)
public class Config {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.POST, "/auth/**").permitAll());

		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

}
