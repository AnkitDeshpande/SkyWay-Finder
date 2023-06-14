package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.FleetMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface FleetMasterService {
	public boolean createFleet(FleetMaster fleetMaster) throws SomethingWentWrongException;

	public boolean modifyFleet(FleetMaster fleetMaster) throws SomethingWentWrongException;

	public boolean deleteFleet(int fleetId) throws SomethingWentWrongException, NoRecordFoundException;

	public FleetMaster getFleet(int fleetId) throws NoRecordFoundException;

	public List<FleetMaster> getAllFleet() throws SomethingWentWrongException;
}
