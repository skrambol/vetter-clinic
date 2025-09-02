package com.skrambol.vetter_clinic.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.skrambol.vetter_clinic.entity.Clinic;
import com.skrambol.vetter_clinic.entity.Veterinarian;
import com.skrambol.vetter_clinic.repository.ClinicRepository;
import com.skrambol.vetter_clinic.repository.VeterinarianRepository;

import lombok.RequiredArgsConstructor;

/**
 * ClinicServiceImpl
 */
@RequiredArgsConstructor
@Service
public class ClinicServiceImpl implements ClinicService {
	private final ClinicRepository clinicRepository;
	private final VeterinarianRepository veterinarianRepository;

	@Override
	public Clinic createClinic(Clinic clinic, int headVeterinarianId) {
		Veterinarian headVeterinarian = veterinarianRepository.findById(headVeterinarianId)
				.orElseThrow(() -> new RuntimeException("veterinarian not found. ID: " + headVeterinarianId));

		clinic.setId(0);
		clinic.setHeadVeterinarian(headVeterinarian);
		headVeterinarian.setHeadClinic(clinic);

		clinic.addVeterinarian(headVeterinarian);

		return clinicRepository.save(clinic);
	}

	@Override
	public List<Clinic> listAllClinics(String specialization) {
		if (specialization != null && specialization.isBlank()) {
			return clinicRepository.findBySpecialization(specialization);
		}

		return clinicRepository.findAll();
	}

	@Override
	public Set<Veterinarian> listAllVeterinariansFromClinic(int clinicId) {
		Clinic clinic = clinicRepository.findById(clinicId)
				.orElseThrow(() -> new RuntimeException("clinic does not exist. ID: " + clinicId));

		return clinic.getAffiliatedVeterinarians();
	}

	@Override
	public void joinClinic(int clinicId, int veterinarianId) {
		Clinic clinic = clinicRepository.findById(clinicId)
				.orElseThrow(() -> new RuntimeException("clinic does not exist. ID: " + clinicId));
		Veterinarian veterinarian = veterinarianRepository.findById(veterinarianId)
				.orElseThrow(() -> new RuntimeException("veterinarian not found. ID: " + veterinarianId));

		try {
			clinic.addVeterinarian(veterinarian);
			clinicRepository.save(clinic);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("veterinarian is already affiliated to clinic");
		}
	}

	@Override
	public void leaveClinic(int clinicId, int veterinarianId) {
		Clinic clinic = clinicRepository.findById(clinicId)
				.orElseThrow(() -> new RuntimeException("clinic does not exist. ID: " + clinicId));
		Veterinarian veterinarian = veterinarianRepository.findById(veterinarianId)
				.orElseThrow(() -> new RuntimeException("veterinarian not found. ID: " + veterinarianId));

		clinic.removeVeterinarian(veterinarian);
	}

}
