package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.FareMasterDAO;
import com.fbs.Entity.FareMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FareMasterImplementation implements FareMasterService {

	@Override
	public boolean newFare(FareMaster fareMaster) throws SomethingWentWrongException {
		FareMasterDAO fm = new com.fbs.Dao.FareMasterImplementation();
		return fm.newFare(fareMaster);
	}

	@Override
	public boolean modifyFare(FareMaster fareMaster) throws SomethingWentWrongException {
		FareMasterDAO fm = new com.fbs.Dao.FareMasterImplementation();
		return fm.modifyFare(fareMaster);
	}

	@Override
	public boolean deleteFare(int fareId) throws SomethingWentWrongException, NoRecordFoundException {
		FareMasterDAO fm = new com.fbs.Dao.FareMasterImplementation();
		return fm.deleteFare(fareId);
	}

	@Override
	public FareMaster getFare(int fareMasterId) throws NoRecordFoundException {
		FareMasterDAO fm = new com.fbs.Dao.FareMasterImplementation();
		return fm.getFare(fareMasterId);
	}

	@Override
	public List<FareMaster> getAllFareList() throws SomethingWentWrongException {
		FareMasterDAO fm = new com.fbs.Dao.FareMasterImplementation();
		return fm.getAllFareList();
	}

}
