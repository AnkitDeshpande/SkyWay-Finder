package com.fbs.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface FlightService {
	void saveFlight(Flight flight) throws SomethingWentWrongException;

	void updateFlight(Flight flight, long id) throws NoRecordFoundException, SomethingWentWrongException;

	void deleteFlight(long flightId) throws NoRecordFoundException, SomethingWentWrongException;

	Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException;

	List<Flight> getAllFlights() throws SomethingWentWrongException;

	List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException;

	Flight getFlightByFlightNumber(long flightNumber) throws SomethingWentWrongException, NoRecordFoundException;

	List<Flight> filterFlightsByDepartureTime(String source, String destination)
			throws SomethingWentWrongException, NoRecordFoundException;

	List<Flight> filterFlightsByDate(LocalDateTime startTime, LocalDateTime endTime)
			throws SomethingWentWrongException, NoRecordFoundException;
	List<Flight> filterFlightsByPrice(int minPrice, int maxPrice)
			throws SomethingWentWrongException, NoRecordFoundException;
}
