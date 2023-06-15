package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface BookingService {
    void saveBooking(Booking booking) throws SomethingWentWrongException;
    void updateBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException;
    void deleteBooking(Booking booking) throws NoRecordFoundException, SomethingWentWrongException;
    Booking getBookingById(int bookingId) throws NoRecordFoundException, SomethingWentWrongException;
    List<Booking> getAllBookings() throws SomethingWentWrongException;
    List<Booking> getBookingsByPassenger(Passenger passenger) throws SomethingWentWrongException;
    List<Booking> getBookingsByFlight(Flight flight) throws SomethingWentWrongException;
}
