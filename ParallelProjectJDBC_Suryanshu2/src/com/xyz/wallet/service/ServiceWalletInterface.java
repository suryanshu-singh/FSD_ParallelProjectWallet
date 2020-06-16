package com.xyz.wallet.service;

import java.sql.SQLException;

import com.xyz.wallet.bean.Customer;

public interface ServiceWalletInterface {

	public int createAccount(Customer customer);

	// public void lowBalance(Integer amount);
	public void deposit(Customer c);

	public void withdraw(Customer c);

	public void fundTransfer(Integer amount, Customer c1, Customer c2);

	public void printTransaction(Customer c) throws SQLException;

}
