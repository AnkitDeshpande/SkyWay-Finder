package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.FareMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface FareMasterService {
	public boolean newFare(FareMaster fareMaster)  throws SomethingWentWrongException;

	public boolean modifyFare(FareMaster fareMaster) throws SomethingWentWrongException;

	public boolean deleteFare(int fareId) throws SomethingWentWrongException, NoRecordFoundException;

	public FareMaster getFare(int fareMasterId) throws NoRecordFoundException;

	public List<FareMaster> getAllFareList() throws SomethingWentWrongException;

}
