package com.xyz.wallet.dao;

import java.sql.SQLException;

import com.xyz.wallet.bean.*;

public interface DaoInterface {

	public int createAccount(Customer customer);

	// public void lowBalance(Integer amount);
	public void deposit(Customer c);

	public void withdraw(Customer c);

	public void fundTransfer(Integer amount, Customer c1, Customer c2);

	public void printTransaction(Customer c) throws SQLException;

	// public String findInsuranceScheme(Integer salary, String designation);
	// public ArrayList<Customer> display();

}
