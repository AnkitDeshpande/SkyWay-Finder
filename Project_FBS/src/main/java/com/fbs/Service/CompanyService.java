package com.fbs.Service;

import java.util.List;

import com.fbs.Entity.Company;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;

public interface CompanyService {
    void saveCompany(Company company) throws SomethingWentWrongException;
    void updateCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException;
    void deleteCompany(Company company) throws NoRecordFoundException, SomethingWentWrongException;
    Company getCompanyById(int companyId) throws NoRecordFoundException, SomethingWentWrongException;
    List<Company> getAllCompanies() throws SomethingWentWrongException;
}
