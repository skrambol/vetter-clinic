package com.skrambol.vetter_clinic.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User
 */
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@CreatedDate
	@Column(name = "datetime_created")
	private Instant datetimeCreated;

	@LastModifiedDate
	@Column(name = "datetime_updated")
	private Instant datetimeUpdated;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getDatetimeCreated() {
		return datetimeCreated;
	}

	public void setDatetimeCreated(Instant datetimeCreated) {
		this.datetimeCreated = datetimeCreated;
	}

	public Instant getDatetimeUpdated() {
		return datetimeUpdated;
	}

	public void setDatetimeUpdated(Instant datetimeUpdated) {
		this.datetimeUpdated = datetimeUpdated;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", isActive=" + isActive + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + "]";
	}
}
