package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.FareMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FareMasterImplementation implements FareMasterService {

	@Override
	public boolean newFare(FareMaster fareMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFare(FareMaster fareMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFare(int fareId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FareMaster getFare(int fareMasterId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FareMaster> getAllFareList() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
