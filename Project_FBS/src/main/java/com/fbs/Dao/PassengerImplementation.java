package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PassengerImplementation implements PassengerDAO {

	@Override
	public boolean newPassenger(Passenger passenger) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Passenger> getPassenger(int bookingId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
