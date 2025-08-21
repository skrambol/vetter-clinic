package com.skrambol.vetter_clinic.service;

import org.springframework.stereotype.Service;

import com.skrambol.vetter_clinic.entity.Owner;
import com.skrambol.vetter_clinic.entity.User;
import com.skrambol.vetter_clinic.entity.Veterinarian;
import com.skrambol.vetter_clinic.repository.OwnerRepository;
import com.skrambol.vetter_clinic.repository.VeterinarianRepository;

import lombok.RequiredArgsConstructor;

/**
 * AuthServiceImpl
 */
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

	private final OwnerRepository ownerRepository;
	private final VeterinarianRepository veterinarianRepository;

	@Override
	public Owner register(User user, Owner owner) {
		user.setId(0);
		user.setActive(true);
		owner.setId(0);
		owner.setUser(user);
		return ownerRepository.save(owner);
	}

	@Override
	public Veterinarian register(User user, Veterinarian veterinarian) {
		user.setId(0);
		user.setActive(true);
		veterinarian.setId(0);
		veterinarian.setUser(user);
		return veterinarianRepository.save(veterinarian);
	}

}
