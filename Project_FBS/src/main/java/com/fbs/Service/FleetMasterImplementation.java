package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.FleetMaster;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class FleetMasterImplementation implements FleetMasterService {

	@Override
	public boolean createFleet(FleetMaster fleetMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFleet(FleetMaster fleetMaster) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFleet(int fleetId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FleetMaster getFleet(int fleetId) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FleetMaster> getAllFleet() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
