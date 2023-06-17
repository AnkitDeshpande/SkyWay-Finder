package com.fbs.Dao;

import java.time.LocalDateTime;
import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
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
	public void updateFlight(Flight flight, long id) throws NoRecordFoundException, SomethingWentWrongException {

		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			Flight existingFlight = em.find(Flight.class, id);
			if (existingFlight == null) {
				throw new NoRecordFoundException("Flight not found with ID: " + id);
			}

			System.out.println("-----------------------");
			System.out.println(existingFlight);
			System.out.println("-----------------------");
			existingFlight.setFlightNumber(flight.getFlightNumber());
			existingFlight.setSource(flight.getSource());
			existingFlight.setDestination(flight.getDestination());
			existingFlight.setDepartureTime(flight.getDepartureTime());
			existingFlight.setArrivalTime(flight.getArrivalTime());
			existingFlight.setePrice(flight.getePrice());
			existingFlight.setbPrice(flight.getbPrice());
			em.merge(existingFlight);

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
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String q = "FROM Flight f";
			Query query = em.createQuery(q);
			List<Flight> flights = (List<Flight>) query.getResultList();
			tx.commit();
			return flights;
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}

	@Override
	public List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException {
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String Q = "SELECT f FROM Flight f WHERE f.company.id = :id";
			Query query = em.createQuery(Q);
			query.setParameter("id", company.getId());
			List<Flight> flights = (List<Flight>) query.getResultList();
			if (flights.isEmpty()) {
				throw new NoRecordFoundException("No flights found within the specified price range.");
			}
			tx.commit();
			return flights;
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}

	@Override
	public Flight getFlightByFlightNumber(long flightNumber)
			throws SomethingWentWrongException, NoRecordFoundException {
		try (EntityManager em = EMUtils.connect()) {
			Flight flight = em.find(Flight.class, flightNumber);
			if (flight == null) {
				throw new NoRecordFoundException("No flight found with the given flight number");
			}
			return flight;
		} catch (Exception e) {
			// e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong while retrieving flight");
		}
	}

	@Override
	public List<Flight> filterFlightsByDepartureTime(String source, String destination)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String q = "SELECT f FROM Flight f WHERE f.source = :source AND f.destination = :destination ORDER BY f.departureTime ASC";
			Query query = em.createQuery(q);
			query.setParameter("source", source);
			query.setParameter("destination", destination);
			List<Flight> flights = (List<Flight>) query.getResultList();
			if (flights.isEmpty()) {
				throw new NoRecordFoundException("No flights found for the given source and destination.");
			}

			tx.commit();
			return flights;
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}

	@Override
	public List<Flight> filterFlightsByDate(LocalDateTime startTime, LocalDateTime endTime)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String q = "SELECT f FROM Flight f WHERE f.departureTime >= :startTime AND f.departureTime <= :endTime ORDER BY f.departureTime ASC";
			Query query = em.createQuery(q);
			query.setParameter("startTime", startTime);
			query.setParameter("endTime", endTime);
			List<Flight> flights = query.getResultList();
			if (flights.isEmpty()) {
				throw new NoRecordFoundException("No flights found for the given date range.");
			}
			tx.commit();
			return flights;
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}

	@Override
	public List<Flight> filterFlightsByPrice(int minPrice, int maxPrice)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createQuery("SELECT f FROM Flight f WHERE f.ePrice BETWEEN :minPrice AND :maxPrice");
			query.setParameter("minPrice", minPrice);
			query.setParameter("maxPrice", maxPrice);
			List<Flight> flights = query.getResultList();
			if (flights.isEmpty()) {
				throw new NoRecordFoundException("No flights found within the specified price range.");
			}
			tx.commit();
			return flights;
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}

}
