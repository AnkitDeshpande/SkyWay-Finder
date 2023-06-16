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
	public void saveBooking() throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.saveBooking();

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
	public Booking getBookingsByPassenger(long id) throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getBookingsByPassenger(id);
	}

}
