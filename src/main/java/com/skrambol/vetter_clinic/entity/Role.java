package com.skrambol.vetter_clinic.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Role
 */
@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntityAudit {
	@Column(name = "role")
	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Role() {
	}

}
