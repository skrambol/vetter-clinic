package com.skrambol.vetter_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skrambol.vetter_clinic.entity.Owner;

/**
 * OwnerRepository
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
