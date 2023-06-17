package com.fbs.Service;

import java.util.List;
import java.util.Scanner;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface BookingService {
	void saveBooking(Scanner sc) throws SomethingWentWrongException;

	void deleteBooking(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException;

	Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException;
}
