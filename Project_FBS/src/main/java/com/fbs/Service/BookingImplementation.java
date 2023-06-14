package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.BookingDAO;
import com.fbs.Entity.Booking;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class BookingImplementation implements BookingService {

	@Override
	public boolean newBooking(Booking booking) throws SomethingWentWrongException {
		BookingDAO bd = new com.fbs.Dao.BookingImplementation();
		return bd.newBooking(booking);
	}

	@Override
	public List<Booking> getBookedDetails(int personId) throws SomethingWentWrongException, NoRecordFoundException {
		BookingDAO bd = new com.fbs.Dao.BookingImplementation();
		return bd.getBookedDetails(personId);
	}

	@Override
	public boolean deleteBooking(int bookingId) throws SomethingWentWrongException, NoRecordFoundException {
		BookingDAO bd = new com.fbs.Dao.BookingImplementation();
		return bd.deleteBooking(bookingId);
	}

	@Override
	public Booking getBooking(int bookingId) throws NoRecordFoundException {
		BookingDAO bd = new com.fbs.Dao.BookingImplementation();
		return bd.getBooking(bookingId);
	}

}
