package com.fbs.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passengers")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private String nationality;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "passenger")
	private Set<Booking> bookings;

	// Constructors, getters, and setters

	public Passenger() {
		this.bookings = new HashSet<>();
	}

	public Passenger(String name, String phoneNumber, LocalDate dateOfBirth, String nationality, User user,
			Set<Booking> bookings) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.user = user;
		this.bookings = new HashSet<>();
	}

	// Getters and setters

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	// Overridden equals() and hashCode() methods

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Passenger passenger = (Passenger) o;
		return Objects.equals(name, passenger.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
