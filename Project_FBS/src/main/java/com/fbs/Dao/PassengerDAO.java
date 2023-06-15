package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PassengerDAO {
	void login(String email, String password) throws LoginException;
	void signup(String email, String password) throws LoginException;
    void savePassenger(Passenger passenger) throws SomethingWentWrongException;
    void updatePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException;
    void deletePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException;
    Passenger getPassengerById(int passengerId) throws NoRecordFoundException, SomethingWentWrongException;
    List<Passenger> getAllPassengers() throws SomethingWentWrongException;
    
}

