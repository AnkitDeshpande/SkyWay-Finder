package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PassengerService {
	public boolean newPassenger(Passenger passenger) throws SomethingWentWrongException;

	public List<Passenger> getPassenger(int bookingId) throws NoRecordFoundException;
}
