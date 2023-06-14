package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.LocationMasterDAO;
import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class LocationMasterImplementation implements LocationMasterService {

	@Override
	public boolean createLocation(LocationMaster locationMaster) throws SomethingWentWrongException {
		LocationMasterDAO lm = new com.fbs.Dao.LocationMasterImplementation();
		return lm.createLocation(locationMaster);
	}

	@Override
	public boolean updateLocation(LocationMaster locationMaster)
			throws SomethingWentWrongException, NoRecordFoundException {
		 LocationMasterDAO lm = new com.fbs.Dao.LocationMasterImplementation();
		return lm.updateLocation(locationMaster);
	}

	@Override
	public boolean deleteLocation(int locationId) throws SomethingWentWrongException, NoRecordFoundException {
		LocationMasterDAO lm = new com.fbs.Dao.LocationMasterImplementation();
		return lm.deleteLocation(locationId);
	}

	@Override
	public LocationMaster getLocation(int locationMasterId) throws NoRecordFoundException {
		LocationMasterDAO lm = new com.fbs.Dao.LocationMasterImplementation();
		return lm.getLocation(locationMasterId);
	}

	@Override
	public List<LocationMaster> getAllLocation() throws SomethingWentWrongException {
		LocationMasterDAO lm = new com.fbs.Dao.LocationMasterImplementation();
		return lm.getAllLocation();
	}

}
