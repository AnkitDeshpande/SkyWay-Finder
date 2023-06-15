package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.PassengerDAO;
import com.fbs.Dao.PassengerDaoImpl;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PassengerServImpl implements PassengerService{

	@Override
	public void savePassenger(Passenger passenger) throws SomethingWentWrongException {
		PassengerDAO p1 = new PassengerDaoImpl();
		p1.savePassenger(passenger);
		
	}

	@Override
	public void updatePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException {
		PassengerDAO p1 = new PassengerDaoImpl();
		p1.updatePassenger(passenger);
		
	}

	@Override
	public void deletePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException {
		PassengerDAO p1 = new PassengerDaoImpl();
		p1.deletePassenger(passenger);
		
	}

	@Override
	public Passenger getPassengerById(int passengerId) throws NoRecordFoundException, SomethingWentWrongException {
		PassengerDAO p1 = new PassengerDaoImpl();
	
		return p1.getPassengerById(passengerId);
	}

	@Override
	public List<Passenger> getAllPassengers() throws SomethingWentWrongException {
		PassengerDAO p1 = new PassengerDaoImpl();
		return p1.getAllPassengers();
	}

}
