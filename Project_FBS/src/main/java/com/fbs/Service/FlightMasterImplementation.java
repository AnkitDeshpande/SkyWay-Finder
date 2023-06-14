package com.fbs.Service;

import java.sql.Date;
import java.util.List;

import com.fbs.Dao.FlightDAO;
import com.fbs.Entity.Flight;
import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FlightMasterImplementation implements FlightService {

	@Override
	public boolean newFlight(Flight flightMaster) {
		FlightDAO fd = new com.fbs.Dao.FlightMasterImplementation();
		return fd.newFlight(flightMaster);
	}

	@Override
	public List<Flight> searchFlight(LocationMaster locationMaster, LocationMaster locationMaster2, Date travelDate)
			throws NoRecordFoundException {
		FlightDAO fd = new com.fbs.Dao.FlightMasterImplementation();
		return fd.searchFlight(locationMaster, locationMaster2, travelDate);
	}

	@Override
	public boolean updateRemainingSeats(Flight flightMaster) throws SomethingWentWrongException {
		FlightDAO fd = new com.fbs.Dao.FlightMasterImplementation();
		return fd.updateRemainingSeats(flightMaster);
	}

	@Override
	public List<Flight> getAll() throws SomethingWentWrongException {
		FlightDAO fd = new com.fbs.Dao.FlightMasterImplementation();
		return fd.getAll();
	}

	@Override
	public Flight getFlight(int flightId) throws NoRecordFoundException {
		FlightDAO fd = new com.fbs.Dao.FlightMasterImplementation();
		return fd.getFlight(flightId);
	}

}
