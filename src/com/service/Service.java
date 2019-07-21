package com.service;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.bean.Customer;
import com.dao.DAO;
import com.exception.UserDefineException;

public class Service {

	Scanner sc = new Scanner(System.in);		// Creating a Scanner Object.
	Customer c;										
	DAO d = new DAO();				// Creating a DAO object.
	long accountNo;
	
	public void createAccount() {

		double a = Math.random()%100;            // Creating a random number
		long accountNo =(long)(a*1234567898);    // Mutliplying with a dummy no. to get dummy account no.
                String name;
		this.accountNo = accountNo;
		do{System.out.println("Enter the Name");
		name = sc.next();
                }while(!Pattern.matches("([A-Z])*([a-z])*", name));
	
		System.out.println("Enter the Number");
		String number = sc.next();
		try{
			Long.parseLong(number);                                                                                                             
		if(number.length() == 10) {
		System.out.println("Enter the IDno.");
		int Idno = sc.nextInt();
		System.out.println("Enter the Balance to be deposit.");
		int deposit = sc.nextInt();
		c = new Customer(name,number,Idno,deposit); 
		c.setAccountNo(accountNo);
	
		c.setBalance(deposit);
	
		d.trans("Initially "+deposit,accountNo);
		
		System.out.println("Your account is Created Successfully");
		System.out.println("Account number is :" + c.getAccountNo());
		d.create(c);
		
		
		}
		else
		try{
                    throw new UserDefineException("Number should be of 10 digits");
                }catch(Exception exc){
                }
                    }catch(Exception e ) {
                        System.out.println("Number should contain only digits");}
		}
        
	public void showDetails() {
			System.out.println("Enter the Account no.");
			Long showaccount = sc.nextLong();
			if(d.getHash().containsKey(showaccount)) {
				System.out.println(d.getHash().get(showaccount));
			}
			else
				System.out.println("No such Account Number");
	}

	public void deposite() {
	System.out.println("Enter the account number");
	long accountdeposit = sc.nextLong();
	if(d.getHash().containsKey(accountdeposit)){
	System.out.println("Enter the amount to be deposite");	
	int deposite = sc.nextInt();
	d.getHash().get(accountdeposit).setDeposite(deposite);
	int a = d.getHash().get(accountdeposit).getDeposite() + d.getHash().get(accountdeposit).getBalance();
	d.getHash().get(accountdeposit).setBalance(a);
	
	System.out.println("Successfully Deposited");
	d.trans("Deposite "+deposite,accountNo);
	
	}else
		System.out.println("No such Account Number");
	}

	public void withdraw() {
	
                System.out.println("Enter the account number");
		long accountwithdraw = sc.nextLong();
		if(d.getHash().containsKey(accountwithdraw)){
		System.out.println("Enter the amount to be withdraw");	
		int withdraw = sc.nextInt();
		d.getHash().get(accountwithdraw).setWithdraw(withdraw);
		int a = d.getHash().get(accountwithdraw).getBalance() - d.getHash().get(accountwithdraw).getWithdraw();
		if(a>0) {d.getHash().get(accountwithdraw).setBalance(a);

		d.trans("Withdraw "+withdraw,accountNo);
		
		System.out.println("Successfully Withdraw");
		}else
			System.out.println("Insufficient Balance");
			}else
			System.out.println("No such Account Number");
		}

	public void fundTransfer() {
		Long to;
                System.out.println("Enter your account number.");
		Long from = sc.nextLong();
                
		if(d.getHash().containsKey(from)) {
		do{System.out.println("Enter account number to transfer the money.");
		to = sc.nextLong();
                }while(!d.getHash().containsKey(to));
                
                if(from.equals(to)){
                    System.out.println("Both account number must be different");
                }else{
		if(d.getHash().containsKey(to)) {
                System.out.println("Enter the money to be transfer");
		int money = sc.nextInt();
		
		Customer cFrom = (Customer) d.getHash().get(from);
		int fBalance = cFrom.getBalance();
		if(money<fBalance) {
			Customer cTo = (Customer) d.getHash().get(to);
			int totalMoney = cTo.getBalance() + money;
			 cTo.setBalance(totalMoney);
			 d.trans("Deposite"+money+"from account no."+from,to); 
			
			 int totalMony = fBalance - money;
			 cFrom.setBalance(totalMony);
			 d.trans("Transfer"+money+"to account no."+to,from); 
								
			 System.out.println("Successfully Transfer");
			}
		else 
			System.out.println("Insufficient Money");
		}else 
			System.out.println("Invalid Account Number");
		}}else 
			System.out.println("Invalid Account Number");
		}
        
	public void printTransaction() {
		
                System.out.println("Enter the Account Number");
		long transAcc = sc.nextLong();
		
		if(d.getTrans().containsValue(transAcc))
		{
			System.out.println(get(d.getTrans(),transAcc));
			
		}
		else {
			System.out.println("No such Account");
		}
	}
	
        public String get(HashMap<String,Long>hm,Long acc) {
		String s = "";
		
		for(String key : hm.keySet()) {
			if(hm.get(key).equals(acc)) {
				s += key + " ; ";
				}
			}
		return s;
	}
	
}