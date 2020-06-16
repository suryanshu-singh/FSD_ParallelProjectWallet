package com.xyz.wallet.service;

import java.sql.SQLException;

import com.xyz.wallet.bean.Customer;
import com.xyz.wallet.dao.*;

public class ServiceWalletInterfaceClass implements ServiceWalletInterface {
	DaoClass dao = new DaoClass();

	public int createAccount(Customer customer) {
		return dao.createAccount(customer);
	}

	public void deposit(Customer c) {
		dao.deposit(c);
	}

	public void withdraw(Customer c) {
		dao.withdraw(c);
	}

	public void fundTransfer(Integer amount, Customer c1, Customer c2) {
		dao.fundTransfer(amount, c1, c2);
	}

	public void printTransaction(Customer c) throws SQLException {
		dao.printTransaction(c);
	}

}
