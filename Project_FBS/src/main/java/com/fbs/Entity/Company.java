package com.fbs.Entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Company_Name")
    private String name;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "contact_number")
    private String contactNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "website")
    private String website;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Flight> flights;

    // Constructors, getters, and setters

    public Company() {
        this.flights = new HashSet<>();
    }

    public Company(String name, String location, String contactNumber, String email, String website,
			Set<Flight> flights) {
		super();
		this.name = name;
		this.location = location;
		this.contactNumber = contactNumber;
		this.email = email;
		this.website = website;
		this.flights = new HashSet<>();
	}



	// Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    // Overridden equals() and hashCode() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", website=" + website + "]";
	}
    
}


