package com.fbs.UI;

import java.util.Scanner;

import com.fbs.Enums.AdminCredentials;

public class MainUI {

	private static void adminLogin(Scanner sc) {
        
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter admin password: ");
        String password = sc.nextLine();
        
        if (username.equals(AdminCredentials.USERNAME.getValue()) &&
            password.equals(AdminCredentials.PASSWORD.getValue())) {
            System.out.println("Admin login successfull !");
            System.out.println("Welcome Ankit !");
            System.out.println("-----------------------------------------------------------------------------");
            adminOperations(sc);
        } else {
            System.out.println("Invalid username or password.");
        }
	}

	private static void adminOperations(Scanner sc) {
		
	}

	private static void userLogin(Scanner sc) {
		
	}

	private static void userSignUp(Scanner sc) {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please select an option:");
		System.out.println("1. Admin login");
		System.out.println("2. User login");
		System.out.println("3. Not a user? Signup");
		System.out.println("4. Exit");

		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Admin login selected.");
			adminLogin(sc);
			break;
		case 2:
			System.out.println("User login selected.");
			userLogin(sc);
			break;
		case 3:
			System.out.println("Not a user? Signup selected.");
			userSignUp(sc);
			break;
		case 4:
			System.out.println("Bye-Bye, Have a Nice Day.");
			break;
		default:
			System.out.println("Invalid choice. Enter choice between 1-4");
		}
		
		System.out.println("-----------------------------------------------------------------------------");

		sc.close();
	}

}
