package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.AddressDetail;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface AddressDetailsDAO {
	public boolean modifyAddress(AddressDetail addressDetail) throws SomethingWentWrongException, NoRecordFoundException;

	public boolean addNewAddress(AddressDetail addressDetail) throws SomethingWentWrongException;

	public List<AddressDetail> getAddressList(int personId) throws SomethingWentWrongException, NoRecordFoundException;

	public boolean deleteAddress(int addressId) throws SomethingWentWrongException;
}
