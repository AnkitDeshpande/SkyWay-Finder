package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.AddressDetail;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class AddressDetailsImplementation implements AddressDetailsService {

	@Override
	public boolean modifyAddress(AddressDetail addressDetail)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewAddress(AddressDetail addressDetail) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AddressDetail> getAddressList(int personId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress(int addressId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

}
