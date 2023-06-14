package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PassengerDAO {
	public boolean newPassenger(Passenger passenger) throws SomethingWentWrongException;

	public List<Passenger> getPassenger(int bookingId) throws NoRecordFoundException;
}
