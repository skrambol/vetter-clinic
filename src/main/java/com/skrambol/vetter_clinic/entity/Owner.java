package com.skrambol.vetter_clinic.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Owner
 */
@Data
@Entity
@Table(name = "owners")
public class Owner extends BaseEntityAudit {
	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Owner() {
	}
}
