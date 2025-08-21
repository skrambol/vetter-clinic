package com.skrambol.vetter_clinic.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
import com.skrambol.vetter_clinic.entity.Veterinarian;
import com.skrambol.vetter_clinic.repository.OwnerRepository;
import com.skrambol.vetter_clinic.repository.UserRepository;
import com.skrambol.vetter_clinic.repository.VeterinarianRepository;

/**
 * AuthServiceImpl
 */
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private VeterinarianRepository veterinarianRepository;

	@Override
	public Owner register(User user, Owner owner) {
		owner.setUser(user);
		return ownerRepository.save(owner);
	}

	@Override
	public Veterinarian register(User user, Veterinarian veterinarian) {
		veterinarian.setUser(user);
		return veterinarianRepository.save(veterinarian);
	}

}
