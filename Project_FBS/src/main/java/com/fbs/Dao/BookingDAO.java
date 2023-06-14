package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Booking;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface BookingDAO {
	public boolean newBooking(Booking booking)  throws SomethingWentWrongException;

	public List<Booking> getBookedDetails(int personId) throws SomethingWentWrongException, NoRecordFoundException;

	public boolean deleteBooking(int bookingId)  throws SomethingWentWrongException, NoRecordFoundException;

	public Booking getBooking(int bookingId) throws NoRecordFoundException;

}
