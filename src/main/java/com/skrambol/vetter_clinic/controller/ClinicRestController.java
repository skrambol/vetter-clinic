package com.skrambol.vetter_clinic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ClinicRestController
 */
@RestController
@RequestMapping("/clinic")
public class ClinicRestController {
	// get all clinics GET / ?specialization=
	@GetMapping("/")
	public ResponseEntity<?> findClinics() {
		return null;
	}

	@PostMapping("/")
	public ResponseEntity<?> createClinic() {
		return null;
	}

	// get clinic GET /id
	@GetMapping("/:id")
	public ResponseEntity<?> getClinicById() {
		return null;
	}

	// join clinic POST /id
	@PostMapping("/:id")
	public ResponseEntity<?> joinClinic() {
		return null;
	}

	// leave clinic DELETE /id
	@DeleteMapping("/:id")
	public ResponseEntity<?> leaveClinic() {
		return null;
	}

}
