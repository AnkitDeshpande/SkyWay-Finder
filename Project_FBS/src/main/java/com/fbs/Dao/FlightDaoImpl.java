package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FlightDaoImpl implements FlightDAO {

	@Override
	public void saveFlight(Flight flight) throws SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getAllFlights() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlightsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
