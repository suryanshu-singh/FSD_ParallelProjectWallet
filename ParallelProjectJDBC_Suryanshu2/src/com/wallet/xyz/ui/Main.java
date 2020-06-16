package com.wallet.xyz.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.xyz.wallet.bean.Customer;
//import com.xyz.wallet.bean.Customer.*;
import com.xyz.wallet.service.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		ServiceWalletInterfaceClass service = new ServiceWalletInterfaceClass();

		int option = 0;

		while (option != 5) {
			System.out.println("Welcome to Payment Wallet Application");
			System.out.println("Press 1 to create Bank Account:");
			System.out.println("Press 2 to Deposit to bank acoount:");
			System.out.println("Press 3 to Withdraw from bank account:");
			System.out.println("Press 4 to Transfer Fund:");
			System.out.println("Press 5 to Print Transaction");
			System.out.println("Press 6 to exit");

			System.out.println("Enter your choice");

			option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				// name,gender,address,contactno,email
				System.out.println("Enter name");
				String name = scan.nextLine();

				System.out.println("Enter gender");
				String gender = scan.nextLine();

				// scan.nextLine();

				System.out.println("Enter Address");
				String address = scan.nextLine();

				System.out.println("Enter Contact Number");
				String contactno = scan.nextLine();

				System.out.println("Enter Email");
				String email = scan.nextLine();

				System.out.println("Enter 4 digit Pin");
				int pin = scan.nextInt();
				scan.nextLine();
				Customer c = new Customer(name, gender, address, contactno, email, pin);
				service.createAccount(c);
				break;
			case 2:
				System.out.println("Enter Account Number");
				Integer in = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Deposit amount");
				Integer ff = scan.nextInt();
				scan.nextLine();
				Customer c2 = new Customer(in, ff);
				service.deposit(c2);
				break;
			case 3:
				System.out.println("Enter Account Number");
				Integer inp = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Withdraw amount");
				Integer wa = scan.nextInt();
				scan.nextLine();
				Customer c3 = new Customer(inp, wa);
				service.withdraw(c3);
				break;
			case 4:
				System.out.println("Enter Sender Account Number ");
				Integer input = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Amount");
				Integer am = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Receiver Account Number");
				int ra = scan.nextInt();
				scan.nextLine();
				Customer c4 = new Customer(input, am);
				Customer c5 = new Customer(ra, am);
				service.fundTransfer(am, c4, c5);
				break;

			case 5:
				System.out.println("Enter Account Number");
				Integer input1 = scan.nextInt();
				scan.nextLine();
				Customer c6 = new Customer(input1);
				
				try
				{
				service.printTransaction(c6);
				}catch(SQLException e)
				{
					System.out.println("Failure in printing");
				}
				
				break;

			case 6:
				System.exit(0);
			default:
				continue;
			}
		}
	}
}
