package com.fbs.UI;

import java.util.Scanner;

import com.fbs.Exception.LoginException;
import com.fbs.Service.PassengerServImpl;
import com.fbs.Service.PassengerService;

public class UserUI {
	static void userLogin(Scanner sc) {
		System.out.println("Enter email : ");
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
		System.out.println("Enter email : ");
		String email = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		PassengerService p1 = new PassengerServImpl();
		try {
			p1.signup(email, password);
			MainUI.main(new String[0]);
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	public static void searchFlights(Scanner sc) {
		
		System.out.println("Search for flights option selected.");
	}

	public static void viewFlightOptions(Scanner sc) {
		// Logic to view flight options
		System.out.println("View flight options option selected.");
	}

	public static void filterFlightOptions(Scanner sc) {
		// Logic to filter flight options
		System.out.println("Filter flight options option selected.");
	}

	public static void selectFlightsForBooking(Scanner sc) {
		// Logic to select flights for booking
		System.out.println("Select flights for booking option selected.");
	}

	public static void confirmBooking(Scanner sc) {
		// Logic to confirm booking
		System.out.println("Confirm booking option selected.");
	}

	public static void viewBookings(Scanner sc) {
		// Logic to view bookings
		System.out.println("View bookings option selected.");
	}

	public static void cancelBooking(Scanner sc) {
		// Logic to cancel booking
		System.out.println("Cancel booking option selected.");
	}

	public static void showUserMenu() {
		System.out.println("1. Search for flights");
		System.out.println("2. View flight options");
		System.out.println("3. Filter flight options");
		System.out.println("4. Select flights for booking");
		System.out.println("5. Confirm booking");
		System.out.println("6. View bookings");
		System.out.println("7. Cancel booking");
		System.out.println("0. Logout");
	}

	public static void processUserMenuOption(Scanner sc) {
		showUserMenu();
		System.out.println("Enter You choice !");
		int ch = sc.nextInt();
		do {
			switch (ch) {
			case 1:
				searchFlights(sc);
				break;
			case 2:
				viewFlightOptions(sc);
				break;
			case 3:
				filterFlightOptions(sc);
				break;
			case 4:
				selectFlightsForBooking(sc);
				break;
			case 5:
				confirmBooking(sc);
				break;
			case 6:
				viewBookings(sc);
				break;
			case 7:
				cancelBooking(sc);
				break;
			case 0:
				System.out.println("Thanks for using our services !");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		} while (ch != 0);

	}
}
