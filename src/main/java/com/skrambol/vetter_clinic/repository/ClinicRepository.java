package com.skrambol.vetter_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skrambol.vetter_clinic.entity.Clinic;

/**
 * ClinicRepository
 */
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

}
