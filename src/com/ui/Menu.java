package com.ui;


import java.util.Scanner;
import com.service.Service;

public class Menu {

	public static void main(String args[]) {
		                                                                                       
		Service s = new Service ();
		
		//Accepting the input from the User.
		Scanner sc = new Scanner(System.in);
		do {
                    //Printing the menu bar.
		System.out.println("***************************************************************************");
		System.out.println("1. Create Account \n 2. Show Balance \n 3. Deposite "
				+ "\n 4. Withdraw \n 5. Fund Transfer \n 6. Print Transcaction \n 7. Exit");
		System.out.println("***************************************************************************");
                System.out.println("Choose any option : ");
		int n = sc.nextInt();
		
		// According to input from user the method is called using switch case.
		switch(n) {
		
		case 1 :s.createAccount();
			break;
		case 2: s.showDetails();
			break;
		case 3: s.deposite();
			break;
		case 4: s.withdraw();
			break;
		case 5: s.fundTransfer();
			break;
		case 6: s.printTransaction();
			break;
		case 7: System.exit(0);
		default :
			System.out.println("Enter the valid choice");
		
		}}while(true);
	}
}