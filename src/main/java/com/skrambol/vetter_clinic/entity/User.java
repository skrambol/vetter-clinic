package com.skrambol.vetter_clinic.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Role> roles;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private Owner owner;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private Veterinarian veterinarian;

	public User() {
		roles = new ArrayList<Role>();
	}

	public void addRole(Role role) {
		roles.add(role);
		role.setUser(this);
	}
}
