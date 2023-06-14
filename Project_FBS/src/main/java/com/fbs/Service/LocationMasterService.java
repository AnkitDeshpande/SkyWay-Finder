package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.LocationMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface LocationMasterService {
	public boolean createLocation(LocationMaster locationMaster) throws SomethingWentWrongException;

	public boolean updateLocation(LocationMaster locationMaster) throws SomethingWentWrongException, NoRecordFoundException;

	public boolean deleteLocation(int locationId) throws SomethingWentWrongException, NoRecordFoundException;

	public LocationMaster getLocation(int locationMasterId) throws NoRecordFoundException;

	public List<LocationMaster> getAllLocation() throws SomethingWentWrongException;
}
