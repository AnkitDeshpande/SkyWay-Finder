package com.fbs.Service;

import java.util.List;

import com.fbs.Dao.CompanyDAO;
import com.fbs.Dao.CompanyDaoImpl;
import com.fbs.Entity.Company;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public class CompanyServImpl implements CompanyService {

	@Override
	public void saveCompany(Company company) throws SomethingWentWrongException {
		CompanyDAO c1 = new CompanyDaoImpl();
		c1.saveCompany(company);

	}

	@Override
	public void updateCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException {
		CompanyDAO c1 = new CompanyDaoImpl();
		c1.updateCompany(company);
	}

	@Override
	public void deleteCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException {
		CompanyDAO c1 = new CompanyDaoImpl();
		c1.deleteCompany(company);
	}

	@Override
	public Company getCompanyById(int companyId) throws NoRecordFoundException, SomethingWentWrongException {
		CompanyDAO c1 = new CompanyDaoImpl();
		return c1.getCompanyById(companyId);
	}

	@Override
	public List<Company> getAllCompanies() throws SomethingWentWrongException {
		CompanyDAO c1 = new CompanyDaoImpl();
		return c1.getAllCompanies();
	}

}
