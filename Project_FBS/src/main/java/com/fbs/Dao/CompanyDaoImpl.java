package com.fbs.Dao;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

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
		} finally {
			em.close();
		}

	}

	@Override
	public void updateCompany(Company c) throws NoRecordFoundException, SomethingWentWrongException {
		System.out.println("Enter the company ID: ");
		Scanner sc = new Scanner(System.in);
		Long companyId = sc.nextLong();
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			Company company = em.find(Company.class, companyId);

			et.begin();
			company.setName(c.getName());
			company.setLocation(c.getLocation());
			company.setContactNumber(c.getContactNumber());
			company.setEmail(c.getEmail());
			company.setWebsite(c.getWebsite());
			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public void deleteCompany(Company c) throws NoRecordFoundException, SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			Company company = em.find(Company.class, c.getId());
			// Delete associated flights
	        Set<Flight> flights = company.getFlights();
	        for (Flight flight : flights) {
	            // Delete associated bookings for each flight
	            Set<Booking> bookings = flight.getBookings();
	            for (Booking booking : bookings) {
	                et.begin();
	                em.remove(booking);
	                et.commit();
	            }
	            et.begin();
	            em.remove(flight);
	            et.commit();
	        }

			et.begin();
			em.remove(company);
			et.commit();

		} catch (Exception e) {
			et.rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}

	@Override
	public Company getCompanyById(int companyId) throws NoRecordFoundException, SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			Company company = em.find(Company.class, (long) companyId);
			if (company == null) {
				throw new NoRecordFoundException("Company not found");
			}
			return company;
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		}
	}

	@Override
	public List<Company> getAllCompanies() throws SomethingWentWrongException {
		try (EntityManager em = EMUtils.connect()) {
			String Q = "Select c from Company c";
			Query query = em.createQuery(Q);
			List<Company> companies = query.getResultList();
			return companies;
		} catch (Exception e) {
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		}
	}

}
