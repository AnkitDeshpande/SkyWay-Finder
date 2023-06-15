package com.fbs.Dao;

import java.time.LocalDateTime;
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
import jakarta.persistence.Query;

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
	public void deleteFlight(long id) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			Query query = em.createQuery("DELETE FROM Flight f WHERE f.id = :flightId");
			query.setParameter("flightId", id);
			int deletedCount = query.executeUpdate();
			et.commit();

			if (deletedCount == 0) {
	            throw new NoRecordFoundException("Flight not found with ID: " + id);
	        }
			
		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			Flight flight = em.find(Flight.class, (long) flightId);
			if (flight == null) {
				throw new NoRecordFoundException("Company not found");
			}
			return flight;
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		}
	}

	@Override
	public List<Flight> getAllFlights() throws SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			String Q = "Select f from Flight f";
			Query query = em.createQuery(Q);
			List<Flight> flights = (List<Flight>) query.getResultList();
			return flights;
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		}
	}

	@Override
	public List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			
			String Q = "SELECT f FROM Flight f WHERE f.company.id = :id";
			Query query = em.createQuery(Q);
			query.setParameter("id", company.getId());
			List<Flight> flights = (List<Flight>) query.getResultList();
			return flights;
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		}
	}

	@Override
	public List<Flight> getFlightsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> filterFlightsByDepartureTime(LocalDateTime startTime, LocalDateTime endTime)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
