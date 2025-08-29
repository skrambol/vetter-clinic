package com.skrambol.vetter_clinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Role
 */
@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntityAudit {
	public static enum RoleEnum {
		OWNER,
		VETERINARIAN
	}

	@Column(name = "role")
	private String role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Role() {
	}

	public Role(RoleEnum role) {
		this.role = role.toString();
	}

}
