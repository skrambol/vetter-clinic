package com.skrambol.vetter_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skrambol.vetter_clinic.dto.request.auth.RegisterUserDto;
import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
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
	public ResponseEntity<?> register(@RequestBody RegisterUserDto userDto) {
		Owner owner = new Owner();
		User user = userMapper.toUser(userDto);

		authService.register(user, owner);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
