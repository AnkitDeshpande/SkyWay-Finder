package com.fbs.Dao;

import java.util.List;
import java.util.Scanner;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class FlightDaoImpl implements FlightDAO {

	@Override
	public void saveFlight(Flight flight) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			em.persist(flight);
			et.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public void updateFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			Flight existingFlight = em.find(Flight.class, flight.getId());
			if (existingFlight == null) {
				throw new NoRecordFoundException("Flight not found with ID: " + flight.getId());
			}

			existingFlight.setFlightNumber(flight.getFlightNumber());
			existingFlight.setSource(flight.getSource());
			existingFlight.setDestination(flight.getDestination());
			existingFlight.setDepartureTime(flight.getDepartureTime());
			existingFlight.setArrivalTime(flight.getArrivalTime());

			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			em.remove(flight);
			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException {

		return null;
	}

	@Override
	public List<Flight> getAllFlights() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
