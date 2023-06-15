package com.fbs.Dao;

import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CompanyDaoImpl implements CompanyDAO {

	@Override
	public void saveCompany(Company company) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.connect();
			et = em.getTransaction();
			
			et.begin();
			em.persist(company);
			et.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}

	}

	@Override
	public void updateCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompanyById(int companyId) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getAllCompanies() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
