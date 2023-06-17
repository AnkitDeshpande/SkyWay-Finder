package com.fbs.Service;

import java.util.Scanner;

import com.fbs.Dao.BookingDAO;
import com.fbs.Dao.BookingDaoImpl;
import com.fbs.Entity.Booking;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class BookingServImpl implements BookingService {

	@Override
	public void saveBooking(Scanner sc) throws SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.saveBooking(sc);

	}

	@Override
	public void deleteBooking(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		b1.deleteBooking(sc);
	}

	@Override
	public Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException {
		BookingDAO b1 = new BookingDaoImpl();
		return b1.getBookingById(bookingId);
	}

}
