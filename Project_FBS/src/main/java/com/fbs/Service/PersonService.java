package com.fbs.Service;

import com.fbs.Entity.Person;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface PersonService {
	public boolean addPerson(Person person) throws SomethingWentWrongException;

	public boolean modifyPersonDetails(Person person) throws SomethingWentWrongException;

	public Person getUser(String emailAddress) throws SomethingWentWrongException, NoRecordFoundException;

	public boolean deletePerson(String emailAddress) throws NoRecordFoundException;

}
