package com.skrambol.vetter_clinic.service;

import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
import com.skrambol.vetter_clinic.entity.Veterinarian;

/**
 * AuthService
 */
public interface AuthService {
	public Owner register(User user, Owner owner);

	public Veterinarian register(User user, Veterinarian veterinarian);

}
