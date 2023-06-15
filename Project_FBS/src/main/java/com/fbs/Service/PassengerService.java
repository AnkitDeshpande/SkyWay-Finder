package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PassengerService {
    void savePassenger(Passenger passenger) throws SomethingWentWrongException;
    void updatePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException;
    void deletePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException;
    Passenger getPassengerById(int passengerId) throws NoRecordFoundException, SomethingWentWrongException;
    List<Passenger> getAllPassengers() throws SomethingWentWrongException;
}

