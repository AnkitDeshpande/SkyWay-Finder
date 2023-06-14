package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Flight;
import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface FlightService {
	public boolean newFlight(Flight flightMaster);

	public List<Flight> searchFlight(LocationMaster locationMaster, LocationMaster locationMaster2,
			java.sql.Date travelDate) throws NoRecordFoundException;

	public boolean updateRemainingSeats(Flight flightMaster) throws SomethingWentWrongException;

	public List<Flight> getAll() throws SomethingWentWrongException;

	public Flight getFlight(int flightId) throws NoRecordFoundException;
}
