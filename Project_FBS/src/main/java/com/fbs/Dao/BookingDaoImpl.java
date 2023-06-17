package com.fbs.Dao;

import java.time.LocalDate;
import java.util.Scanner;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Entity.User;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Service.BookingServImpl;
import com.fbs.Service.BookingService;
import com.fbs.Service.FlightServImpl;
import com.fbs.Service.FlightService;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BookingDaoImpl implements BookingDAO {

	@Override
	public void saveBooking(Scanner sc) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();

			System.out.println("Enter your user Id: ");
			long id = sc.nextLong();

			System.out.println("Enter passenger name:");
			String passengerName = sc.next();

			System.out.println("Enter passenger phone number:");
			String phoneNumber = sc.next();

			System.out.println("Enter passenger date of birth (yyyy-MM-dd):");
			LocalDate dateOfBirth = LocalDate.parse(sc.next());

			System.out.println("Enter passenger nationality:");
			String nationality = sc.next();

			System.out.println("Enter flight number:");
			String flightNumber = sc.next();

			System.out.println(
					"Enter seat number: *Note: Economy seats are between 1-100, and Business seats are 101-130:");
			int seatNumber = sc.nextInt();

			String queryStr = "SELECT f.id FROM Flight f WHERE f.flightNumber = :flightNumber";
			Query query = em.createQuery(queryStr);
			query.setParameter("flightNumber", flightNumber);

			Long flightId = (Long) query.getSingleResult();
			if (flightId == null) {
				// Flight not found with the given flight number
				throw new NoRecordFoundException("Flight not found with the given flight number.");
			}

			Flight flight = em.find(Flight.class, flightId);
			User user = em.find(User.class, id);

			if (flight == null) {
				throw new NoRecordFoundException("Flight not found with the given flight number.");
			}

			// Validate seat number
			boolean isValidSeatNumber = false;
			if (seatNumber >= 1 && seatNumber <= 100) {
				isValidSeatNumber = true;
				// Check if the economy seat is available
				int economySeats = flight.getEconomySeats();
				if (economySeats > 0) {
					// Seat is available, deduct the seat count and charge the customer
					flight.setEconomySeats(economySeats - 1);
				} else {
					throw new SomethingWentWrongException("Economy seat not available.");
				}
			} else if (seatNumber >= 101 && seatNumber <= 130) {
				isValidSeatNumber = true;
				// Check if the business seat is available
				int businessSeats = flight.getBusinessSeats();
				if (businessSeats > 0) {
					// Seat is available, deduct the seat count and charge the customer
					flight.setBusinessSeats(businessSeats - 1);
				} else {
					throw new SomethingWentWrongException("Business seat not available.");
				}
			} else {
				throw new SomethingWentWrongException("Invalid seat number.");
			}

			if (!isValidSeatNumber) {
				throw new SomethingWentWrongException("Invalid seat number.");
			}

			// Create a new Passenger object
			Passenger passenger = new Passenger(passengerName, phoneNumber, dateOfBirth, nationality,
					flight.getSource(), flight.getDestination(), flight, user);

			// Create the booking
			Booking booking = new Booking(flight, passenger, seatNumber);

			int ePrice = flight.getePrice();
			int bPrice = flight.getbPrice();

			int amountToDeduct;
			if (seatNumber >= 1 && seatNumber <= 100) {
				// Seat is economy
				amountToDeduct = ePrice;
			} else {
				// Seat is business
				amountToDeduct = bPrice;
			}

			// Check if the user has sufficient amount
			int currentAmount = user.getWalletAmmount();
			if (currentAmount >= amountToDeduct) {
				// Deduct the amount from the user's account
				user.setWalletAmmount(currentAmount - amountToDeduct);
			} else {
				throw new SomethingWentWrongException("Insufficient amount in the user's account.");
			}

			em.merge(user);
			em.persist(passenger);
			em.persist(booking);

			et.commit();
			System.out.println("Booking Confirmed Successfully.");
			System.out.println("Your passenger Id is : " + booking.getId());
		} catch (Exception e) {
			e.printStackTrace();
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw new SomethingWentWrongException("Error while committing the transaction", e);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void deleteBooking(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {
		System.out.println("Enter booking id : ");
		long id = sc.nextLong();
		EntityManager em = null;
		try {
			em = EMUtils.connect();
			em.getTransaction().begin();
			Booking booking = em.find(Booking.class, id);
			em.remove(booking);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Error while deleting booking", e);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Booking getBookingById(int userId) throws NoRecordFoundException, SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			Booking booking = em.find(Booking.class, userId);
			System.out.println(booking);
			System.out.println();
			if (booking == null) {
				throw new NoRecordFoundException("Booking not found for the given user ID.");
			}
			return booking;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Error while retrieving booking by user ID", e);
		}
	}
}
