package com.fbs.Service;

import com.fbs.Entity.Flight;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrong;

public class FBS_Service_Impl implements FBS_Service{

	@Override
	public boolean adminLogin(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addFlight(Flight f) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFlightPrice(int id, double price) throws NoRecordFoundException, SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFlight(int id) throws NoRecordFoundException, SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminLogout() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userSignUp(String username, String password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userLogin(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchFlight() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewFlight() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean filterFlightOption() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bookFlight() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean viewBooking() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelBooking() throws NoRecordFoundException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void userLogout() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
	}

}
