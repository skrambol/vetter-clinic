package com.skrambol.vetter_clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skrambol.vetter_clinic.entity.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
