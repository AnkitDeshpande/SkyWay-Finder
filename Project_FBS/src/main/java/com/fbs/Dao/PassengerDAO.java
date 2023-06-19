package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Passenger;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PassengerDAO {
	void login(String email, String password) throws LoginException;
	void signup(String email, String password, String fname, String lname, int amt) throws LoginException;
}

