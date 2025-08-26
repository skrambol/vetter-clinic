package com.skrambol.vetter_clinic.service;

import org.springframework.dao.DataIntegrityViolationException;
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
		try {
			return ownerRepository.save(owner);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle custom error
			throw new RuntimeException("username already exists");
		}
	}

	@Override
	public Veterinarian register(User user, Veterinarian veterinarian) {
		user.setId(0);
		user.setActive(true);
		veterinarian.setId(0);
		veterinarian.setUser(user);
		try {
			return veterinarianRepository.save(veterinarian);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle custom error
			throw new RuntimeException("username already exists");
		}
	}

}
