package com.fbs.Service;

import com.fbs.Dao.PersonDAO;
import com.fbs.Entity.Person;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class PersonImplementation implements PersonService{

	@Override
	public boolean addPerson(Person person) throws SomethingWentWrongException {
		PersonDAO pd = new com.fbs.Dao.PersonImplementation();
		return pd.addPerson(person);
	}

	@Override
	public boolean modifyPersonDetails(Person person) throws SomethingWentWrongException {
		PersonDAO pd = new com.fbs.Dao.PersonImplementation();
		return false;
	}

	@Override
	public Person getUser(String emailAddress) throws SomethingWentWrongException, NoRecordFoundException {
		PersonDAO pd = new com.fbs.Dao.PersonImplementation();
		return null;
	}

	@Override
	public boolean deletePerson(String emailAddress) throws NoRecordFoundException {
		PersonDAO pd = new com.fbs.Dao.PersonImplementation();
		return false;
	}

}
