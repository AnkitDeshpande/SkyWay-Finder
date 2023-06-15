package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class BookingDaoImpl implements BookingDAO {

	@Override
	public void saveBooking(Booking booking) throws SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBookings() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByFlight(Flight flight) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
