package com.fbs.Dao;

import java.util.Scanner;

import com.fbs.Entity.Booking;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface BookingDAO {
	void saveBooking(Scanner sc) throws SomethingWentWrongException;

	void deleteBooking(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException;

	Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException;

}
