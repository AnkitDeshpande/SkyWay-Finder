package com.fbs.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fare_master")
@NamedQuery(name = "FareMaster.findAll", query = "SELECT f FROM FareMaster f")
public class FareMaster implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FARE_MASTER_ID")
    private int fareMasterId;

    @Column(name = "BUSINESS_CLASS")
    private int businessClass;

    @Column(name = "ECONOMY_CLASS")
    private int economyClass;

    @Column(name = "PREMIUM_CLASS")
    private int premiumClass;

    // bi-directional many-to-one association to FlightMaster
    @OneToMany(mappedBy = "fareMaster")
    private Set<Flight> flightMasters;

    public FareMaster() {
    }

    public FareMaster(int businessClass, int economyClass, int premiumClass,
			Set<Flight> flightMasters) {
		super();
		this.businessClass = businessClass;
		this.economyClass = economyClass;
		this.premiumClass = premiumClass;
		this.flightMasters = flightMasters;
	}

	public int getFareMasterId() {
        return this.fareMasterId;
    }

    public int getBusinessClass() {
        return this.businessClass;
    }

    public void setBusinessClass(int businessClass) {
        this.businessClass = businessClass;
    }

    public int getEconomyClass() {
        return this.economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    public int getPremiumClass() {
        return this.premiumClass;
    }

    public void setPremiumClass(int premiumClass) {
        this.premiumClass = premiumClass;
    }

    public Set<Flight> getFlightMasters() {
        return this.flightMasters;
    }

    public void setFlightMasters(Set<Flight> flightMasters) {
        this.flightMasters = flightMasters;
    }

    public Flight addFlightMaster(Flight flightMaster) {
        getFlightMasters().add(flightMaster);
        flightMaster.setFareMaster(this);

        return flightMaster;
    }

    public Flight removeFlightMaster(Flight flightMaster) {
        getFlightMasters().remove(flightMaster);
        flightMaster.setFareMaster(null);

        return flightMaster;
    }
}
