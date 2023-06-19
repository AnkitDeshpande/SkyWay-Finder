package com.fbs.UI;

import java.util.Scanner;

import com.fbs.Enums.AdminCredentials;
import com.fbs.Exception.SomethingWentWrongException;

public class MainUI {

	static void adminLogin(Scanner sc) {

		System.out.print("Enter admin username: ");
		String username = sc.next();

		System.out.print("Enter admin password: ");

		String password = sc.next();

		if (username.equals(AdminCredentials.USERNAME.getValue())
				&& password.equals(AdminCredentials.PASSWORD.getValue())) {
			System.out.println("Admin login successfull !");
			System.out.println("Welcome Ankit !");
			System.out.println("-----------------------------------------------------------------------------");
			MainUI.adminMenu(sc);
		} else {
			System.out.println("Invalid username or password.");
		}
	}

	static void adminOperations() {
		System.out.println("╔═══════════════════════════════════════════╗");
		System.out.println("║               Welcome to the System       ║");
		System.out.println("╠═══════════════════════════════════════════╣");
		System.out.println("║             Select an option below:       ║");
		System.out.println("║                                           ║");
		System.out.println("║   1. Add a Company                        ║");
		System.out.println("║   2. Update Company                       ║");
		System.out.println("║   3. Delete Company                       ║");
		System.out.println("║   4. View Company by ID                   ║");
		System.out.println("║   5. View All Companies                   ║");
		System.out.println("║   6. Add a Flight                         ║");
		System.out.println("║   7. Update a Flight                      ║");
		System.out.println("║   8. Delete a Flight                      ║");
		System.out.println("║   9. Get a Flight by ID                   ║");
		System.out.println("║  10. View All Flights                     ║");
		System.out.println("║  11. Get Flights by Company               ║");
		System.out.println("║  12. Get all Users                        ║");
		System.out.println("║   0. Logout                               ║");
		System.out.println("╚═══════════════════════════════════════════╝");
	}

	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			adminOperations();
			System.out.print("Enter selection: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AdminUI.addCompany(sc);
				break;
			case 2:
				AdminUI.updateCompany(sc);
				break;
			case 3:
				AdminUI.deletecompany(sc);
				break;
			case 4:
				AdminUI.viewCompanyById(sc);
				break;
			case 5:
				AdminUI.viewAllCompanies();
				break;
			case 6:
				AdminUI.addFlight(sc);
				break;
			case 7:
				AdminUI.updateFlight(sc);
				break;
			case 8:
				AdminUI.deleteFlight(sc);
				break;
			case 9:
				AdminUI.getFlightById(sc);
				break;
			case 10:
				AdminUI.viewAllFlights();
				break;
			case 11:
				AdminUI.getFlightsByCompany(sc);
				break;
			case 12:
				try {
					AdminUI.getAllUsers();
				} catch (SomethingWentWrongException e) {
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("Bye Bye Admin");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
		System.out.println("-----------------------------------------------------------------------------");
		main(new String[0]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          Welcome to Our System         ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║         Please select an option:       ║");
		System.out.println("║                                        ║");
		System.out.println("║  1. Admin login                        ║");
		System.out.println("║  2. User login                         ║");
		System.out.println("║  3. Not a user? Signup                 ║");
		System.out.println("║  4. Exit                               ║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.print("Enter your choice: ");
		int choice = 0;

		do {
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Admin login selected.");
				adminLogin(sc);
				break;
			case 2:
				System.out.println("User login selected.");
				UserUI.userLogin(sc);
				break;
			case 3:
				System.out.println("Not a user? Signup selected.");
				UserUI.userSignUp(sc);
				break;
			case 4:
				System.out.println("Bye-Bye, Have a Nice Day.");
				break;
			default:
				System.out.println("Invalid choice. Enter choice between 1-4");
			}

			System.out.println("-----------------------------------------------------------------------------");
		} while (choice != 0);

		sc.close();

	}

}
