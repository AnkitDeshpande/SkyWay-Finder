package com.fbs.UI;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Scanner;

import com.fbs.Dao.CompanyDAO;
import com.fbs.Entity.Company;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Service.CompanyServImpl;
import com.fbs.Service.CompanyService;


public class AdminUI {

	public static void addCompany(Scanner sc) {
		
		Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter company name: ");
	    String name = scanner.nextLine();

	    Company company = new Company(name);

	    try {
	        CompanyService c1 = new CompanyServImpl();
	        c1.saveCompany(company);
	    	
	        System.out.println("Company added successfully.");
	    } catch (SomethingWentWrongException e) {
	        System.out.println("Failed to add company. Error: " + e.getMessage());
	    }
		
	}

	public static void updateCompany(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void deletecompany(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void viewAllCompanies(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void addFlight() {
		// TODO Auto-generated method stub
		
	}

	public static void updateFlight() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteFlight() {
		// TODO Auto-generated method stub
		
	}

	public static void viewAllFlights() {
		// TODO Auto-generated method stub
		
	}

	public static void getAllUsers() {
		// TODO Auto-generated method stub
		
	}

}
