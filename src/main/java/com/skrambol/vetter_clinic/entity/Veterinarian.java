package com.skrambol.vetter_clinic.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Veterinarian
 */
@Data
@Entity
@Table(name = "veterinarians")
public class Veterinarian extends BaseEntityAudit {
	@Column(name = "education")
	private String education;

	@Column(name = "years_in_practice")
	private int yearsInPractice;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToMany(mappedBy = "affiliatedVeterinarians")
	private Set<Clinic> clinics;

	@OneToOne(mappedBy = "headVeterinarian")
	private Clinic headClinic;

	public Veterinarian() {
		clinics = new HashSet<Clinic>();
	}
}
