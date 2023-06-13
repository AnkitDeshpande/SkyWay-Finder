package com.fbs.Dao;

import com.fbs.Entity.Flight;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrong;

public interface FBS_Dao {
	public boolean adminLogin(String username, String password) throws LoginException;

	public void addFlight(Flight f) throws SomethingWentWrong;

	public void updateFlightPrice(int id, double price) throws NoRecordFoundException, SomethingWentWrong;

	public void deleteFlight(int id) throws NoRecordFoundException, SomethingWentWrong;

	public void adminLogout() throws SomethingWentWrong;

	public void userSignUp(String username, String password) throws SomethingWentWrong;

	public boolean userLogin(String username, String password) throws LoginException;

	public boolean searchFlight() throws NoRecordFoundException, NoRecordFoundException;

	public boolean viewFlight() throws NoRecordFoundException, NoRecordFoundException;
	
	public boolean filterFlightOption() throws NoRecordFoundException, NoRecordFoundException;
	
	public boolean bookFlight() throws NoRecordFoundException, NoRecordFoundException;
	
	public boolean viewBooking() throws NoRecordFoundException, NoRecordFoundException;
	
	public boolean cancelBooking() throws NoRecordFoundException, NoRecordFoundException;
	
	public void userLogout() throws SomethingWentWrong;
}
