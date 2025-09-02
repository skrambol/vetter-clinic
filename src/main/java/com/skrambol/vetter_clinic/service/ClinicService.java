package com.skrambol.vetter_clinic.service;

import java.util.List;
import java.util.Set;

import com.skrambol.vetter_clinic.entity.Clinic;
import com.skrambol.vetter_clinic.entity.Veterinarian;

/**
 * AuthService
 */
public interface ClinicService {
	public Clinic createClinic(Clinic clinic, int headVeterinarianId);

	public List<Clinic> listAllClinics(String specialization);

	public Set<Veterinarian> listAllVeterinariansFromClinic(int clinicId);

	public void joinClinic(int clinicId, int veterinarianId);

	public void leaveClinic(int clinicId, int veterinarianId);
}
