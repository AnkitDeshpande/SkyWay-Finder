package com.fbs.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.fbs.Dao.FlightDAO;
import com.fbs.Dao.FlightDaoImpl;
import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FlightServImpl  implements FlightService{

	@Override
	public void saveFlight(Flight flight) throws SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		f1.saveFlight(flight);
	}

	@Override
	public void updateFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		f1.updateFlight(flight);
	}

	@Override
	public void deleteFlight(long flight) throws NoRecordFoundException, SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		f1.deleteFlight(flight);
	}

	@Override
	public Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		return f1.getFlightById(flightId);
	}

	@Override
	public List<Flight> getAllFlights() throws SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		return f1.getAllFlights();
	}

	@Override
	public List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		return f1.getFlightsByCompany(company);
	}

	@Override
	public List<Flight> getFlightsByPassenger(Passenger passenger) throws SomethingWentWrongException {
		FlightDAO f1 = new FlightDaoImpl();
		return f1.getFlightsByPassenger(passenger);
	}

	@Override
	public List<Flight> filterFlightsByDepartureTime(LocalDateTime startTime, LocalDateTime endTime)
			throws SomethingWentWrongException, NoRecordFoundException {
		FlightDAO f1 = new FlightDaoImpl();
		return f1.filterFlightsByDepartureTime(startTime, endTime);
	}

}
