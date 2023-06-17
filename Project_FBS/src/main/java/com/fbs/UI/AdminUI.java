package com.fbs.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.fbs.Entity.Company;
import com.fbs.Entity.Flight;
import com.fbs.Entity.User;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Service.CompanyServImpl;
import com.fbs.Service.CompanyService;
import com.fbs.Service.FlightServImpl;
import com.fbs.Service.FlightService;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class AdminUI {

	public static void addCompany(Scanner scanner) {
		System.out.println("Enter company name: ");
		String name = scanner.next();

		System.out.println("Enter company location: ");
		String location = scanner.next();

		System.out.println("Enter company contact number: ");
		String contactNumber = scanner.next();

		System.out.println("Enter company email: ");
		String email = scanner.next();

		System.out.println("Enter company website: ");
		String website = scanner.next();

		Company company = new Company(name, location, contactNumber, email, website, null);

		try {
			CompanyService c1 = new CompanyServImpl();
			c1.saveCompany(company);

			System.out.println("Company added successfully.");
		} catch (SomethingWentWrongException e) {
			System.out.println("Failed to add company. Error: " + e.getMessage());
		}

	}

	public static void updateCompany(Scanner scanner) {

		System.out.println("Enter company name: ");
		String name = scanner.next();

		System.out.println("Enter company location: ");
		String location = scanner.next();

		System.out.println("Enter company contact number: ");
		String contactNumber = scanner.next();

		System.out.println("Enter company email: ");
		String email = scanner.next();

		System.out.println("Enter company website: ");
		String website = scanner.next();

		Company company = new Company(name, location, contactNumber, email, website, null);

		try {
			CompanyService c1 = new CompanyServImpl();
			c1.updateCompany(company);
			System.out.println("---------------------------------");
			System.out.println("company Updated Successfully");
			System.out.println("---------------------------------");
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	public static void deletecompany(Scanner sc) {
		System.out.println("Enter the company ID: ");
		Long companyId = sc.nextLong();
		Company company = EMUtils.connect().find(Company.class, companyId);
		CompanyService c1 = new CompanyServImpl();
		try {
			c1.deleteCompany(company);
			System.out.println("---------------------------------");
			System.out.println("Company Deleted Successfully");
			System.out.println("---------------------------------");
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	public static void viewCompanyById(Scanner sc) {
		System.out.println("Enter the company ID: ");
		int companyId = sc.nextInt();
		CompanyService c1 = new CompanyServImpl();
		try {
			Company company = c1.getCompanyById(companyId);
			if (company != null) {
				System.out.println("---------------------------------");
				System.out.println("Company ID: " + company.getId());
				System.out.println("Name: " + company.getName());
				System.out.println("Contact Number: " + company.getContactNumber());
				System.out.println("Email: " + company.getEmail());
				System.out.println("Location: " + company.getLocation());
				System.out.println("Website: " + company.getWebsite());
				System.out.println("---------------------------------");
			} else {
				System.out.println("Company not found with ID: " + companyId);
			}
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	public static void viewAllCompanies() {
		try {
			CompanyService c1 = new CompanyServImpl();
			List<Company> companies = c1.getAllCompanies();
			if (companies.isEmpty()) {
				System.out.println("No companies found.");
			} else {
				System.out.println("---------------------------------");
				System.out.println("List of companies:");
				for (Company company : companies) {
					System.out.println("---------------------------------");
					System.out.println("Company ID: " + company.getId());
					System.out.println("Name: " + company.getName());
					System.out.println("Contact Number: " + company.getContactNumber());
					System.out.println("Email: " + company.getEmail());
					System.out.println("Location: " + company.getLocation());
					System.out.println("Website: " + company.getWebsite());
					System.out.println("---------------------------------");
				}
			}
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}

	public static void addFlight(Scanner sc) {
		System.out.println("Enter company ID:");
		int companyId = sc.nextInt();

		System.out.println("Enter flight number:");
		String flightNumber = sc.next();

		System.out.println("Enter source:");
		String source = sc.next();

		System.out.println("Enter destination:");
		String destination = sc.next();

		sc.nextLine();

		System.out.println("Enter arrival time (yyyy-MM-dd HH:mm:ss):");
		String arrivalTimeString = sc.nextLine();
		LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeString,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("Enter departure time (yyyy-MM-dd HH:mm:ss):");
		String departureTimeString = sc.nextLine();
		LocalDateTime departureTime = LocalDateTime.parse(departureTimeString,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("Enter flight Economy seat price:");
		int eprice = sc.nextInt();

		System.out.println("Enter flight Economy seat price:");
		int bprice = sc.nextInt();

		Company company = EMUtils.connect().find(Company.class, companyId);

		if (company != null) {
			try {
				Flight f1 = new Flight(flightNumber, company, source, destination, departureTime, arrivalTime, eprice,
						bprice);
				FlightService f2 = new FlightServImpl();
				f2.saveFlight(f1);
				System.out.println("---------------------------------");
				System.out.println("Flight Added to Company");
				System.out.println("---------------------------------");
			} catch (SomethingWentWrongException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Company not found with ID: " + companyId);
		}
	}

	public static void updateFlight(Scanner sc) {
		System.out.println("Enter company ID:");
		int companyId = sc.nextInt();

		System.out.println("Enter the flight id :");
		long id = sc.nextLong();

		System.out.println("Enter flight number:");
		String flightNumber = sc.next();

		System.out.println("Enter source:");
		String source = sc.next();

		System.out.println("Enter destination:");
		String destination = sc.next();

		sc.nextLine();

		System.out.println("Enter arrival time (yyyy-MM-dd HH:mm:ss):");
		String arrivalTimeString = sc.nextLine();
		LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeString,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("Enter departure time (yyyy-MM-dd HH:mm:ss):");
		String departureTimeString = sc.nextLine();
		LocalDateTime departureTime = LocalDateTime.parse(departureTimeString,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("Enter flight Economy seat price:");
		int eprice = sc.nextInt();

		System.out.println("Enter flight Economy seat price:");
		int bprice = sc.nextInt();

		Company company = EMUtils.connect().find(Company.class, companyId);
		if (company != null) {
			try {
				Flight f1 = new Flight(flightNumber, company, source, destination, departureTime, arrivalTime, eprice,
						bprice);
				FlightService f2 = new FlightServImpl();
				f2.updateFlight(f1, id);
				System.out.println("---------------------------------");
				System.out.println("Flight Updated successfully.");
				System.out.println("---------------------------------");
			} catch (SomethingWentWrongException | NoRecordFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Company not found with ID: " + companyId);
		}
	}

	public static void getFlightById(Scanner sc) {
		System.out.println("Enter Flight ID:");
		int f_Id = sc.nextInt();
		FlightService f2 = new FlightServImpl();
		try {
			Flight flight = f2.getFlightById(f_Id);
			if (flight != null) {
				System.out.println("---------------------------------");
				System.out.println("Flight Details:");
				System.out.println("Flight Number: " + flight.getFlightNumber());
				System.out.println("Company: " + flight.getCompany().getName());
				System.out.println("Source: " + flight.getSource());
				System.out.println("Destination: " + flight.getDestination());
				System.out.println("Departure Time: " + flight.getDepartureTime());
				System.out.println("Arrival Time: " + flight.getArrivalTime());
				System.out.println("Economy Seats Available: " + flight.getEconomySeats());
				System.out.println("Business Seats Available: " + flight.getBusinessSeats());
				System.out.println("Economy Seat Price: " + flight.getePrice());
				System.out.println("Business Seat Price: " + flight.getbPrice());
				System.out.println("---------------------------------");
			} else {
				System.out.println("Flight not found with ID: " + f_Id);
			}
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteFlight(Scanner sc) {
		System.out.println("Enter Flight ID:");
		long flightId = sc.nextLong();

		try {
			FlightService flightService = new FlightServImpl();
			Flight f1 = EMUtils.connect().find(Flight.class, flightId);
			flightService.deleteFlight(flightId);
			System.out.println("Flight deleted successfully");
		} catch (NoRecordFoundException | SomethingWentWrongException e) {
			System.out.println("Flight not found with ID: " + flightId);
		}
	}

	public static void viewAllFlights() {
		FlightService f2 = new FlightServImpl();
		try {
			List<Flight> flights = f2.getAllFlights();
			if (flights != null) {
				System.out.println("Flight Details:");
				for (Flight flight : flights) {
					System.out.println("---------------------------------");
					System.out.println();
					System.out.println("Flight Number: " + flight.getFlightNumber());
					System.out.println("Company: " + flight.getCompany().getName());
					System.out.println("Source: " + flight.getSource());
					System.out.println("Destination: " + flight.getDestination());
					System.out.println("Departure Time: " + flight.getDepartureTime());
					System.out.println("Arrival Time: " + flight.getArrivalTime());
					System.out.println("Economy Seats Available: " + flight.getEconomySeats());
					System.out.println("Business Seats Available: " + flight.getBusinessSeats());
					System.out.println("Economy Seat Price: " + flight.getePrice());
					System.out.println("Business Seat Price: " + flight.getbPrice());
					System.out.println();
					System.out.println("---------------------------------");
				}

			} else {
				System.out.println("Flights not found");
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getFlightsByCompany(Scanner sc) {
		System.out.println("Enter Company Id: ");
		long id = sc.nextLong();

		FlightService f2 = new FlightServImpl();
		Company c = EMUtils.connect().find(Company.class, id);
		try {
			List<Flight> flights = f2.getFlightsByCompany(c);
			if (flights != null) {
				System.out.println("Flight Details:");
				for (Flight flight : flights) {
					System.out.println("---------------------------------");
					System.out.println();
					System.out.println("Flight Number: " + flight.getFlightNumber());
					System.out.println("Company: " + flight.getCompany().getName());
					System.out.println("Source: " + flight.getSource());
					System.out.println("Destination: " + flight.getDestination());
					System.out.println("Departure Time: " + flight.getDepartureTime());
					System.out.println("Arrival Time: " + flight.getArrivalTime());
					System.out.println();
					System.out.println("---------------------------------");
				}

			} else {
				System.out.println("Flights not found");
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getAllUsers() throws SomethingWentWrongException {
		EntityManager em = EMUtils.connect();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String Q = "SELECT u FROM User u";
			Query query = em.createQuery(Q);
			List<User> users = (List<User>) query.getResultList();
			tx.commit();
			if (users != null) {
				System.out.println("Flight Details:");
				for (User user : users) {
					System.out.println("---------------------------------");
					System.out.println();
					System.out.println("User Id : " + user.getId());
					System.out.println("Name : " + user.getFname() + " "+ user.getLname());
					System.out.println("User handle : " + user.getUsername());
					System.out.println("Handle password: " + user.getPassword());
					System.out.println("Amount in wallet : " + user.getWalletAmmount());
					System.out.println();
					System.out.println("---------------------------------");
				}

			} else {
				System.out.println("Flights not found");
			}
		} catch (Exception e) {
			tx.rollback();
			throw new SomethingWentWrongException("Something went wrong while retrieving company");
		} finally {
			em.close();
		}
	}
}
