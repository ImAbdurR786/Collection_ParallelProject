package com.bean;
//Helper class
    public class Customer {
	//Defining member variable
	String name;
	String number;
	int idno;
	long accountNo ;
	int deposite;
	int balance;
	int withdraw;
	
        public Customer(String name, String number, int idno, int deposit) {
		
		this.name = name;
		this.number = number;
		this.idno = idno;
		this.deposite = deposit;
	}

	public int getDeposite() {
		return deposite;
	}

	public void setDeposite(int deposite) {
		this.deposite = deposite;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
		
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", number=" + number + ", idno=" + idno 
                        + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	

	
}