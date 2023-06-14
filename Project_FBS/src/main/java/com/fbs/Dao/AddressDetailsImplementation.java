package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.AddressDetail;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AddressDetailsImplementation implements AddressDetailsDAO {

	@Override
	public boolean modifyAddress(AddressDetail addressDetail)
			throws SomethingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {

			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			
			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
		}
		return false;
	}

	@Override
	public boolean addNewAddress(AddressDetail addressDetail) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {

			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();

			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public List<AddressDetail> getAddressList(int personId) throws SomethingWentWrongException, NoRecordFoundException {

		try {

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean deleteAddress(int addressId) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {

			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();

			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return false;
		
	}
}
