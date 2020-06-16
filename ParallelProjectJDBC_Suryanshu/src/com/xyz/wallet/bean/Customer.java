package com.xyz.wallet.bean;

public class Customer {

	private Integer pin, salary, accountNo, amount;
	private String name, gender, contactNo, email, address;

	public Customer(String name, String gender, String contactNo, String email, String address, int pin) {
		this.pin = pin;
		this.name = name;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
	}

	public Customer(Integer accountNo, Integer amount) {
		this.setAccountNo(accountNo);
		this.setAmount(amount);
	}

//	public Customer(Customer c1, Customer c2, Integer amount) {
//		this.accountNo =c1.getAccountNo();
//		
//	}

	public Customer(Integer no) {
		this.accountNo = no;
	}

	public Customer() {

	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", address=" + address + ", gender=" + gender
				+ ", ContactNo=" + contactNo + "]";
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

}
