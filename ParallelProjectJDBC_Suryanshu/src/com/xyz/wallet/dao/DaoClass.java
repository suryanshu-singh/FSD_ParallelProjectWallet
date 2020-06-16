package com.xyz.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Scanner;

import com.xyz.wallet.bean.Customer;
//import com.xyz.wallet.dao.ConnectingToDB;

public class DaoClass implements DaoInterface {
	Connection dbCon;

	public DaoClass() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/parallelproject?serverTimezone=IST",
					"root", "");
			// System.out.println("dbcon="+dbCon);
		} catch (SQLException e) {
			System.out.println("Some issues while connecting : " + e.getMessage());
		}
	}

	public int createAccount(Customer customer) {
		Integer no = 0;
		String qryFetch = "insert into customerdetails( Name, Gender, Address, ContactNo, Email, PIN) values(?,?,?,?,?,?)";
		String qryFetch1 = "insert into balance(AccountNumber) values(?)";

		PreparedStatement pstmt, pstmt1;
		try {
			pstmt = dbCon.prepareStatement(qryFetch, java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getGender());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getContactNo());
			pstmt.setString(5, customer.getEmail());
			pstmt.setInt(6, customer.getPin());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				no = rs.getInt(1);
				System.out.println("Let's see:" + no);
				// System.out.println("Generated Emp Id: "+rs.getInt(1));
			}
			pstmt1 = dbCon.prepareStatement(qryFetch1);
			pstmt1.setInt(1, no);
			// pstmt1.setInt(2,0);
			// pstmt1.setString(3, );
			// pstmt1.setString(3,"Transaction details");
			pstmt1.executeUpdate();
			System.out.println("Welcome To XYZ Bank");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Outside everything:" + no);
		return no;

	}

	public void deposit(Customer c) {

		String qryFetch = "update balance set Salary = Salary+? where AccountNumber=?";
		String qryFetch1 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(?,?,?,?)";

		PreparedStatement pstmt1, pstmt2;
		try {
			pstmt1 = dbCon.prepareStatement(qryFetch);
			pstmt1.setInt(1, c.getAmount());
			pstmt1.setInt(2, c.getAccountNo());
			pstmt2 = dbCon.prepareStatement(qryFetch1);
			// System.out.println("Update value is:"+pstmt.executeUpdate());
			pstmt2.setInt(1, c.getAccountNo());
			pstmt2.setInt(2, c.getAccountNo());
			pstmt2.setInt(3, c.getAmount());
			// ResultSet rs = pstmt2.executeQuery();
			pstmt2.setString(4, "Credited");

			if (pstmt1.executeUpdate() > 0) {
				System.out.println("Executed Successfully updation");
				pstmt2.executeUpdate();
			} else {
				System.out.println("Unsucessful operation!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void withdraw(Customer c) {
		String qryFetch = "update balance set Salary = Salary-? where AccountNumber =?";
		String qryFetch1 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(?,?,?,?)";

		PreparedStatement pstmt, pstmt1;
		try {
			pstmt = dbCon.prepareStatement(qryFetch);
			pstmt1 = dbCon.prepareStatement(qryFetch1);
			pstmt.setInt(1, c.getAmount());
			pstmt.setInt(2, c.getAccountNo());

			pstmt1.setInt(1, c.getAccountNo());
			pstmt1.setInt(2, c.getAccountNo());
			pstmt1.setInt(3, c.getAmount());
			pstmt1.setString(4, "Debited");

			if (pstmt.executeUpdate() > 0) {
				pstmt1.executeUpdate();
				System.out.println("Successfully updated");
			}

			else
				System.out.println("Failure");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fundTransfer(Integer amount, Customer c1, Customer c2) {
		String qryFetch = "update balance set Salary = Salary-? where AccountNumber =?";
		String qryFetch1 = "update balance set Salary = Salary+? where AccountNumber =?";
		String qryFetch2 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(?,?,?,?)";

		PreparedStatement pstmt, pstmt1, pstmt2;
		// withdraw( accno1,amount);
		// deposit( accno2,amount);
		try {
			pstmt = dbCon.prepareStatement(qryFetch);
			pstmt1 = dbCon.prepareStatement(qryFetch1);
			pstmt2 = dbCon.prepareStatement(qryFetch2);
			pstmt.setInt(1, c1.getAmount());
			pstmt.setInt(2, c1.getAccountNo());

			pstmt1.setInt(1, c2.getAmount());
			pstmt1.setInt(2, c2.getAccountNo());

			pstmt2.setInt(1, c1.getAccountNo());
			pstmt2.setInt(2, c2.getAccountNo());
			pstmt2.setInt(3, c1.getAmount());
			pstmt2.setString(4, "Transferred from::" + c1.getAccountNo() + "  to::" + c2.getAccountNo());

			if (pstmt.executeUpdate() > 0) {
				pstmt1.executeUpdate();
				pstmt2.executeUpdate();
				System.out.println("Successfully updated");
			}

			else
				System.out.println("Failure");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void printTransaction(Customer c) throws SQLException{
		String qryFetch = "select Details,Amount,TimeStamp from transactions where FromAccountNumber =?";
		PreparedStatement pstmt;
	
			pstmt = dbCon.prepareStatement(qryFetch);
			pstmt.setInt(1, c.getAccountNo());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("Details") + " an amount:" + rs.getInt("Amount") + " At:"
						+ rs.getString("TimeStamp"));
			
			// pstmt.executeLargeUpdate();
		} 
	}

}
