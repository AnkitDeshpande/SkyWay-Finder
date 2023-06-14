package com.fbs.Dao;

import com.fbs.Entity.Person;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PersonImplementation implements PersonDAO{

	@Override
	public boolean addPerson(Person person) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyPersonDetails(Person person) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person getUser(String emailAddress) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePerson(String emailAddress) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
