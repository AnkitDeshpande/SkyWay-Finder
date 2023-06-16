package com.fbs.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.fbs.Entity.Booking;
import com.fbs.Entity.Flight;
import com.fbs.Entity.Passenger;
import com.fbs.Entity.User;
import com.fbs.Exception.LoginException;
import com.fbs.Exception.NoRecordFoundException;
import com.fbs.Exception.SomethingWentWrongException;
import com.fbs.Service.BookingServImpl;
import com.fbs.Service.BookingService;
import com.fbs.Service.FlightServImpl;
import com.fbs.Service.FlightService;
import com.fbs.Service.PassengerServImpl;
import com.fbs.Service.PassengerService;
import com.fbs.Utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UserUI {
	static void userLogin(Scanner sc) {
		System.out.println("Enter Username : ");
		String email = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();

		PassengerService p1 = new PassengerServImpl();
		try {
			p1.login(email, password);
		} catch (LoginException e) {
			e.printStackTrace();
		}

	}

	static void userSignUp(Scanner sc) {
		System.out.println("Enter Username : ");
		String email = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		System.out.println("Enter Your first Name");
		String f_name = sc.next();
		System.out.println("Enter Your last Name");
		String l_name = sc.next();
		System.out.println("Enter Ammount to be added in wallet");
		int amt = sc.nextInt();

		PassengerService p1 = new PassengerServImpl();
		try {
			p1.signup(email, password, f_name, l_name, amt);
			System.out.println("User Signed up successfully.");
			System.out.println("------------------------------");
			MainUI.main(new String[0]);
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	public static void searchFlightsByFlightNumber(Scanner sc) {
		System.out.println("Enter Flight Number :");
		String flightNumber = sc.next();
		FlightService f2 = new FlightServImpl();
		try {
			Flight flight = f2.getFlightByFlightNumber(flightNumber);
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
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}

	public static void viewAllFlights(Scanner sc) {
		FlightService f2 = new FlightServImpl();
		try {
			List<Flight> flights = f2.getAllFlights();
			if (flights != null) {
				for (Flight flight : flights) {
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
				}

			} else {
				System.out.println("Flights not found");
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void filterFlightsByDate(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter Start Date and Time (yyyy-MM-dd HH:mm:ss):");
		String startTimeStr = sc.nextLine();
		LocalDateTime startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		System.out.println("Enter End Date and Time (yyyy-MM-dd HH:mm:ss):");
		String endTimeStr = sc.nextLine();
		LocalDateTime endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		FlightService f1 = new FlightServImpl();
		try {
			List<Flight> flights = f1.filterFlightsByDate(startTime, endTime);
			if (!flights.isEmpty()) {
				for (Flight flight : flights) {
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
				}
			} else {
				System.out.println("No flights found for the given date range.");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}

	}

	public static void filterFlightsByPrice(Scanner sc) {
		System.out.println("Enter Minimum Price :");
		int minPrice = sc.nextInt();
		System.out.println("Enter Maximum Price :");
		int maxPrice = sc.nextInt();

		FlightService f1 = new FlightServImpl();
		try {
			List<Flight> flights = f1.filterFlightsByPrice(minPrice, maxPrice);
			if (!flights.isEmpty()) {
				for (Flight flight : flights) {
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
				}
			} else {
				System.out.println("No flights found for the given date range.");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}

	private static void filterFlightsBySourceAndDestination(Scanner sc) {
		System.out.println("Enter Source :");
		String source = sc.next();
		System.out.println("Enter Destination :");
		String destination = sc.next();
		FlightService f1 = new FlightServImpl();
		try {
			List<Flight> flights = f1.filterFlightsByDepartureTime(source, destination);
			if (flights != null) {
				for (Flight flight : flights) {
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
				}
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}

	public static void confirmBooking(Scanner sc) {
		BookingService b1 = new BookingServImpl();
		try {
			b1.saveBooking();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void viewBookings(Scanner sc) {
		
	}

	public static void cancelBooking(Scanner sc) {

	}

	public static void showUserMenu() {
		System.out.println("1. Search for flights by flight number");
		System.out.println("2. View all flights");
		System.out.println("3. Filter flight by date.");
		System.out.println("4. Filter flight by price");
		System.out.println("5. Filter flight by source and destination");
		System.out.println("6. Confirm Booking");
		System.out.println("7. View bookings");
		System.out.println("8. Cancel booking");
		System.out.println("0. Logout");
	}

	public static void processUserMenuOption(Scanner sc) {
		int ch;
		do {
			showUserMenu();
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				searchFlightsByFlightNumber(sc);
				break;
			case 2:
				viewAllFlights(sc);
				break;
			case 3:
				filterFlightsByDate(sc);
				break;
			case 4:
				filterFlightsByPrice(sc);
				break;
			case 5:
				filterFlightsBySourceAndDestination(sc);
				break;
			case 6:
				confirmBooking(sc);
				break;
			case 7:
				viewBookings(sc);
				break;
			case 8:
				cancelBooking(sc);
				break;
			case 0:
				System.out.println("Thanks for using our services!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		} while (ch != 0);
	}

}
