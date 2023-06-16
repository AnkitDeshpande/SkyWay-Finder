package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface BookingService {
	void saveBooking() throws SomethingWentWrongException;

	void deleteBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException;

	Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException;

	Booking getBookingsByPassenger(long id) throws SomethingWentWrongException;
}
