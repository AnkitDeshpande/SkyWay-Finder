package com.fbs.Service;

import java.sql.Date;
import java.util.List;

import com.fbs.Entity.Flight;
import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FlightMasterImplementation implements FlightService {

	@Override
	public boolean newFlight(Flight flightMaster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> searchFlight(LocationMaster locationMaster, LocationMaster locationMaster2, Date travelDate)
			throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRemainingSeats(Flight flightMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Flight> getAll() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight getFlight(int flightId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
