package com.skrambol.vetter_clinic.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegisterOwnerDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVeterinarianDto extends RegisterUserDto {
	private String education;
	private int yearsInPractice;
}
