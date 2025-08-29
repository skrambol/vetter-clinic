package com.skrambol.vetter_clinic.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegisterUserDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class RegisterUserDto {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
}
