package com.skrambol.vetter_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthRestController
 */
@RestController
@RequestMapping("/auth")
public class AuthRestController {
	@PostMapping("/register")
	public ResponseEntity<?> register() {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
