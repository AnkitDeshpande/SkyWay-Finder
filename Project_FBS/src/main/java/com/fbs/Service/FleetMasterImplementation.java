package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.FleetMasterDAO;
import com.fbs.Entity.FleetMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FleetMasterImplementation implements FleetMasterService {

	@Override
	public boolean createFleet(FleetMaster fleetMaster) throws SomethingWentWrongException {
		FleetMasterDAO fm = new com.fbs.Dao.FleetMasterImplementation();
		return fm.createFleet(fleetMaster);
	}

	@Override
	public boolean modifyFleet(FleetMaster fleetMaster) throws SomethingWentWrongException {
		FleetMasterDAO fm = new com.fbs.Dao.FleetMasterImplementation();
		return fm.modifyFleet(fleetMaster);
	}

	@Override
	public boolean deleteFleet(int fleetId) throws SomethingWentWrongException, NoRecordFoundException {
		FleetMasterDAO fm = new com.fbs.Dao.FleetMasterImplementation();
		return fm.deleteFleet(fleetId);
	}

	@Override
	public FleetMaster getFleet(int fleetId) throws NoRecordFoundException {
		FleetMasterDAO fm = new com.fbs.Dao.FleetMasterImplementation();
		return fm.getFleet(fleetId);
	}

	@Override
	public List<FleetMaster> getAllFleet() throws SomethingWentWrongException {
		FleetMasterDAO fm = new com.fbs.Dao.FleetMasterImplementation();
		return fm.getAllFleet();
	}

}
