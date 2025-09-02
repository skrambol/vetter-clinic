package com.skrambol.vetter_clinic.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Veterinarian
 */
@Data
@Entity
@Table(name = "clinics")
public class Clinic extends BaseEntityAudit {
	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "specialization")
	private String specialization;

	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "head_veterinarian_id", nullable = false)
	private Veterinarian headVeterinarian;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "clinic_veterinarian", joinColumns = @JoinColumn(name = "clinic_id"), inverseJoinColumns = @JoinColumn(name = "veterinarian_id"))
	private Set<Veterinarian> affiliatedVeterinarians;

	public Clinic() {
		affiliatedVeterinarians = new HashSet<Veterinarian>();
	}

	public void addVeterinarian(Veterinarian veterinarian) {
		affiliatedVeterinarians.add(veterinarian);
		veterinarian.getClinics().add(this);
	}

	public void removeVeterinarian(Veterinarian veterinarian) {
		boolean isRemovedFromClinic = affiliatedVeterinarians.remove(veterinarian);
		boolean isRemovedFromVeterinarian = veterinarian.getClinics().remove(this);
	}
}
