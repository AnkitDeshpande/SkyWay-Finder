package com.fbs.Dao;

import java.time.LocalDateTime;
import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface FlightDAO {
    void saveFlight(Flight flight) throws SomethingWentWrongException;
    void updateFlight(Flight flight) throws NoRecordFoundException, SomethingWentWrongException;
    void deleteFlight(long flight) throws NoRecordFoundException, SomethingWentWrongException;
    Flight getFlightById(int flightId) throws NoRecordFoundException, SomethingWentWrongException;
    List<Flight> getAllFlights() throws SomethingWentWrongException;
    List<Flight> getFlightsByCompany(Company company) throws SomethingWentWrongException;
    List<Flight> getFlightsByPassenger(Passenger passenger) throws SomethingWentWrongException;
    List<Flight> filterFlightsByDepartureTime(LocalDateTime startTime, LocalDateTime endTime) throws SomethingWentWrongException, NoRecordFoundException;
}
