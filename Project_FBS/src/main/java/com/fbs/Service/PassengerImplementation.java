package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.PassengerDAO;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PassengerImplementation implements PassengerService {

	@Override
	public boolean newPassenger(Passenger passenger) throws SomethingWentWrongException {
		PassengerDAO pd = new com.fbs.Dao.PassengerImplementation();
		return pd.newPassenger(passenger);
	}

	@Override
	public List<Passenger> getPassenger(int bookingId) throws NoRecordFoundException {
		PassengerDAO pd = new com.fbs.Dao.PassengerImplementation();
		return pd.getPassenger(bookingId);
	}

}
