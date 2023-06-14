package com.fbs.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="fleets")
@NamedQuery(name="FleetMaster.findAll", query="SELECT f FROM FleetMaster f")
public class FleetMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FLEET_MASTER_ID")
	private int fleetMasterId;

	private String code;

	private String model;

	@Column(name="TOTAL_BUSINESS_SEATS")
	private int totalBusinessSeats;

	@Column(name="TOTAL_ECONOMY_SEATS")
	private int totalEconomySeats;

	@Column(name="TOTAL_PREMIUM_SEATS")
	private int totalPremiumSeats;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="fleetMaster")
	private List<Flight> flightMasters;

	public FleetMaster() {
	}

	public int getFleetMasterId() {
		return this.fleetMasterId;
	}

	public void setFleetMasterId(int fleetMasterId) {
		this.fleetMasterId = fleetMasterId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalBusinessSeats() {
		return this.totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
	}

	public int getTotalEconomySeats() {
		return this.totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() {
		return this.totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public List<Flight> getFlightMasters() {
		return this.flightMasters;
	}

	public void setFlightMasters(List<Flight> flightMasters) {
		this.flightMasters = flightMasters;
	}

	public Flight addFlightMaster(Flight flightMaster) {
		getFlightMasters().add(flightMaster);
		flightMaster.setFleetMaster(this);

		return flightMaster;
	}

	public Flight removeFlightMaster(Flight flightMaster) {
		getFlightMasters().remove(flightMaster);
		flightMaster.setFleetMaster(null);

		return flightMaster;
	}
}
