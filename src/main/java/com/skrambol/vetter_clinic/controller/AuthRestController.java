package com.skrambol.vetter_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skrambol.vetter_clinic.dto.request.auth.RegisterOwnerDto;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterUserDto;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterVeterinarianDto;
import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
import com.skrambol.vetter_clinic.entity.Veterinarian;
import com.skrambol.vetter_clinic.mapper.UserMapper;
import com.skrambol.vetter_clinic.service.AuthService;

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

	@PostMapping("/register/owner")
	public ResponseEntity<?> register(@RequestBody RegisterOwnerDto ownerDto) {
		Owner owner = new Owner();
		User user = userMapper.toUser(ownerDto);

		authService.register(user, owner);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

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
