package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.PassengerDAO;
import com.fbs.Dao.PassengerDaoImpl;
import com.fbs.Entity.Passenger;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PassengerServImpl implements PassengerService {

	@Override
	public void login(String email, String password) throws LoginException {
		PassengerDAO p1 = new PassengerDaoImpl();
		p1.login(email, password);
	}

	@Override
	public void signup(String email, String password, String fname, String lname, int amt) throws LoginException {
		PassengerDAO p1 = new PassengerDaoImpl();
		p1.signup(email, password,fname,lname,amt);
	}

}
