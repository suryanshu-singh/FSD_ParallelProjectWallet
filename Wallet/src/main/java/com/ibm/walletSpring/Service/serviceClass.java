package com.ibm.walletSpring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.walletSpring.Dao.DaoClass;
import com.ibm.walletSpring.bean.Customer;

@Component("service")
public class serviceClass {

	@Autowired
	DaoClass dao;
	
	
	public void createAccount(Customer user)
	{
		dao.createAccount(user);
	}
	
	public void deposit(Customer user)
	{
	dao.deposit(user);
	}
//	
	public void withdraw(Customer user)
	{
		dao.withdraw(user);
	}

	public void fundTransfer(Integer am, Customer c4, Customer c5) {
		// TODO Auto-generated method stub
		dao.fundTransfer(am,c4,c5);
		
	} 
//	

	public void printTransaction(Customer c6) {
		// TODO Auto-generated method stub
		dao.printTransaction(c6);
		
	}
	
}
