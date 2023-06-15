package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.BookingDAO;
import com.fbs.Dao.BookingDaoImpl;
import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class BookingServImpl implements BookingService {

	@Override
	public void saveBooking(Booking booking) throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.saveBooking(booking);

	}

	@Override
	public void updateBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.updateBooking(booking);
	}

	@Override
	public void deleteBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.deleteBooking(booking);
	}

	@Override
	public Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getBookingById(bookingId);
	}

	@Override
	public List<Booking> getAllBookings() throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getAllBookings();
	}

	@Override
	public List<Booking> getBookingsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getBookingsByPassenger(passenger);
	}

	@Override
	public List<Booking> getBookingsByFlight(Flight flight) throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getBookingsByFlight(flight);
	}

}
