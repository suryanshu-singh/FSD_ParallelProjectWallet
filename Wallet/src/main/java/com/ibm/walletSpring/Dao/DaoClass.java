package com.ibm.walletSpring.Dao;


import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.ibm.walletSpring.bean.Customer;



@Component("repository")
public class DaoClass {
	

	DataSource datasource;

	NamedParameterJdbcTemplate namedParam;

	@Autowired 
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;

		namedParam = new NamedParameterJdbcTemplate(datasource);
	}

		Date date=new Date();
		String s=date.toString();
		
		
	
	public void createAccount(Customer user) {
		String qry = "insert into customerdetails( Name, Gender, Address, ContactNo, Email, PIN) values(:name,:gender,:address,:cNo, :email,:pin)";
		String accQry="insert into balance(AccountNumber) values(:accno)";
		String s= "select accountnumber from customerdetails where name = :name and gender =:gender and address=:address and contactno =:cNo and email=:email and pin=:pin";
		// jdbcTemplate.(qry, new Object[] {1000,"9999"}, String.class);
		
		// namedParam.query();
		
		
		namedParam.update(qry,
				new MapSqlParameterSource("name", user.getName()).addValue("gender", user.getGender())
						.addValue("address", user.getAddress()).addValue("cNo", user.getContactNo())
						.addValue("email", user.getEmail()).addValue("pin", user.getPin()));
		Integer acc=namedParam.queryForObject(s,new MapSqlParameterSource("name", user.getName()).addValue("gender", user.getGender())
				.addValue("address", user.getAddress()).addValue("cNo", user.getContactNo())
				.addValue("email", user.getEmail()).addValue("pin", user.getPin()) ,Integer.class);
		user.setAccountNo(acc);
		namedParam.update(accQry, new MapSqlParameterSource("accno",user.getAccountNo()));
	}
		

	
	public void deposit(Customer c) {

		String qryFetch = "update balance set Salary = Salary+ :am where AccountNumber=:accno";
		String qryFetch1 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(:faccno,:taccno,:am,:details)";
		
		namedParam.update(qryFetch, new MapSqlParameterSource("am",c.getAmount()).addValue("accno", c.getAccountNo()));

		namedParam.update(qryFetch1, new MapSqlParameterSource("faccno",c.getAccountNo()).addValue("taccno", c.getAccountNo()).addValue("am", c.getAmount()).addValue("details", "Credited"));

	}
	
	public void withdraw(Customer c) {
		
		String qryFetch = "update balance set Salary = Salary-:am where AccountNumber =:accno";
		String qryFetch1 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(:faccno,:taccno,:am,:details)";
		
		namedParam.update(qryFetch, new MapSqlParameterSource("am",c.getAmount()).addValue("accno", c.getAccountNo()));
		namedParam.update(qryFetch1, new MapSqlParameterSource("faccno",c.getAccountNo()).addValue("taccno", c.getAccountNo()).addValue("am", c.getAmount()).addValue("details", "Debited"));

	}



	public void fundTransfer(Integer am, Customer c4, Customer c5) {
		String qryFetch = "update balance set Salary = Salary-:am where AccountNumber =:accno";
		String qryFetch1 = "update balance set Salary = Salary+:am where AccountNumber =:accno";
		String qryFetch2 = "insert into transactions(FromAccountNumber, ToAccountNumber,Amount, Details) values(:faccno,:taccno,:am,:details)";
		namedParam.update(qryFetch, new MapSqlParameterSource("am",c4.getAmount()).addValue("accno", c4.getAccountNo()));
		namedParam.update(qryFetch1, new MapSqlParameterSource("am",c5.getAmount()).addValue("accno", c5.getAccountNo()));
		namedParam.update(qryFetch2, new MapSqlParameterSource("faccno",c4.getAccountNo()).addValue("taccno", c5.getAccountNo()).addValue("am", c4.getAmount()).addValue("details", "Transferred from::" + c4.getAccountNo() + "  to::" + c5.getAccountNo()));
		
		
	}



	public void printTransaction(Customer c6) {
		// TODO Auto-generated method stub
		String qryFetch = "select Details,Amount,TimeStamp from transactions where FromAccountNumber =:am";
		System.out.println(namedParam.queryForList(qryFetch, new MapSqlParameterSource("am",c6.getAccountNo())));
		
	}
	

}