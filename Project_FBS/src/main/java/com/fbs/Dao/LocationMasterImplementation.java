package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class LocationMasterImplementation implements LocationMasterDAO {

	@Override
	public boolean createLocation(LocationMaster locationMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLocation(LocationMaster locationMaster)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLocation(int locationId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LocationMaster getLocation(int locationMasterId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocationMaster> getAllLocation() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
