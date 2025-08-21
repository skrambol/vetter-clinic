package com.skrambol.vetter_clinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * User
 */
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntityAudit {
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	public User() {
	}
}
