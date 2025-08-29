package com.skrambol.vetter_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skrambol.vetter_clinic.dto.request.auth.RegisterOwnerDto;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterVeterinarianDto;
import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
import com.skrambol.vetter_clinic.entity.Veterinarian;
import com.skrambol.vetter_clinic.mapper.UserMapper;
import com.skrambol.vetter_clinic.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * AuthRestController
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthRestController {

	private final UserMapper userMapper;
	private final AuthService authService;

	@Operation(summary = "Register as an Owner")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "User created and given the role of Owner.", content = @Content),
			@ApiResponse(responseCode = "500", description = "User not created due to error.", content = @Content)
	})
	@PostMapping("/register/owner")
	public ResponseEntity<?> register(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User to be registered", required = true, content = @Content(mediaType = "application/json")) @RequestBody RegisterOwnerDto ownerDto) {
		Owner owner = new Owner();
		User user = userMapper.toUser(ownerDto);

		authService.register(user, owner);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Operation(summary = "Register as a Veterinarian")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "User created and given the role of Veterinarian.", content = @Content),
			@ApiResponse(responseCode = "500", description = "User not created due to error.", content = @Content)
	})
	@PostMapping("/register/veterinarian")
	public ResponseEntity<?> register(@RequestBody RegisterVeterinarianDto veterinarianDto) {
		Veterinarian veterinarian = new Veterinarian();
		User user = userMapper.toUser(veterinarianDto);

		veterinarian.setEducation(veterinarianDto.getEducation());
		veterinarian.setYearsInPractice(veterinarianDto.getYearsInPractice());

		authService.register(user, veterinarian);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
