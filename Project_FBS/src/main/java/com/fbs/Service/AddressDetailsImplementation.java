package com.fbs.Service;

import java.util.List;
import com.fbs.Dao.AddressDetailsDAO;
import com.fbs.Entity.AddressDetail;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class AddressDetailsImplementation implements AddressDetailsService {

	@Override
	public boolean modifyAddress(AddressDetail addressDetail)
			throws SomethingWentWrongException, NoRecordFoundException{
		AddressDetailsDAO addr = new com.fbs.Dao.AddressDetailsImplementation();
		return addr.modifyAddress(addressDetail);
	}

	@Override
	public boolean addNewAddress(AddressDetail addressDetail) throws SomethingWentWrongException {
		AddressDetailsDAO addr = new com.fbs.Dao.AddressDetailsImplementation();
		return addr.addNewAddress(addressDetail);
	}

	@Override
	public List<AddressDetail> getAddressList(int personId) throws SomethingWentWrongException, NoRecordFoundException {
		AddressDetailsDAO addr = new com.fbs.Dao.AddressDetailsImplementation();
		return addr.getAddressList(personId);
	}

	@Override
	public boolean deleteAddress(int addressId) throws SomethingWentWrongException {
		AddressDetailsDAO addr = new com.fbs.Dao.AddressDetailsImplementation();
		return addr.deleteAddress(addressId);
	}

}
