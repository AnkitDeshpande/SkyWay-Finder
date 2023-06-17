package com.fbs.Dao;

import java.util.List;
import java.util.Scanner;

import com.fbs.Entity.Passenger;
import com.fbs.Entity.User;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.UI.MainUI;
import com.fbs.UI.UserUI;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class PassengerDaoImpl implements PassengerDAO {

	@Override
	public void login(String email, String password) throws LoginException {
		EntityManager em = null;
		try {
			em = EMUtils.connect();
			System.out.println(em);
			String q = "SELECT u.id FROM User u WHERE u.username = :email AND u.password = :password";
			Query query = em.createQuery(q);
			query.setParameter("email", email);
			query.setParameter("password", password);

			List<Integer> listInt = query.getResultList();
			if (!listInt.isEmpty()) {
				Integer userId = listInt.get(0);
				System.out.println("Logged In Successfully.");

				User loggedInUser = em.find(User.class, userId);
				System.out.println("------------------------------------------------");
				System.out.println("Logged-in User Details:");
				System.out.println("User ID: " + loggedInUser.getId());
				System.out.println("Username: " + loggedInUser.getUsername());
				System.out.println("Password: " + loggedInUser.getPassword());
				System.out.println("First Name: " + loggedInUser.getFname());
				System.out.println("Last Name: " + loggedInUser.getLname());
				System.out.println("Amount in wallet: " + loggedInUser.getWalletAmmount());
				System.out.println("------------------------------------------------");
			} else {
				System.out.println("User does not exist, please sign up.");
				MainUI.main(new String[0]);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("Login failed: " + e.getMessage());
			throw new LoginException("Something went wrong, try again later.");
		} finally {
			em.close();
		}
	}

	@Override
	public void signup(String email, String password, String fname, String lname, int amt) throws LoginException {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.connect();
			et = em.getTransaction();

			et.begin();
			User u1 = new User(fname, password, fname, lname, amt);
			em.persist(u1);
			et.commit();
			MainUI.main(new String[0]);
		} catch (Exception e) {
			throw new LoginException("Something went wrong, try again later.");
		} finally {
			em.close();
		}
	}

	@Override
	public void savePassenger(Passenger passenger) throws SomethingWentWrongException {

	}

	@Override
	public void updatePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException {

	}

	@Override
	public void deletePassenger(Passenger passenger) throws NoRecordFoundException, SomethingWentWrongException {

	}

	@Override
	public Passenger getPassengerById(int passengerId) throws NoRecordFoundException, SomethingWentWrongException {
		return null;
	}

	@Override
	public List<Passenger> getAllPassengers() throws SomethingWentWrongException {
		return null;
	}

}
