package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Booking;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class BookingImplementation implements BookingService {

	@Override
	public boolean newBooking(Booking booking) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Booking> getBookedDetails(int personId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBooking(int bookingId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Booking getBooking(int bookingId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
