package com.skrambol.vetter_clinic.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * BaseEntity
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntityAudit extends BaseEntity {
	@CreatedDate
	@Column(name = "datetime_created")
	private Instant datetimeCreated;

	@LastModifiedDate
	@Column(name = "datetime_updated")
	private Instant datetimeUpdated;
}
