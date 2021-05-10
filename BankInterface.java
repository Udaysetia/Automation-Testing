package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.lang.model.util.ElementScanner6;



public class BankInterface {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Account account=new Account();
	public static String authenciation() throws IOException
	{
		boolean authentiation;
		do {
			System.out.println("Enter your Username");
			String username=br.readLine();
			System.out.println("Enter your Password");
			String password=br.readLine();
			authentiation=account.authentiation(username,password);
			if(authentiation)
			{
				System.out.println("\nLogin Successful");
				return username;
			}
			else
			{
				System.out.println("\nCheck your Username and Password!!!\n");
			}
		} while (!authentiation);
		 return null;
	}
	public static void main(String[] args) throws IOException {
	
	
	int ch=0;
	char flag='y';
	do {
		System.out.println("1.Existing Account\n2.Open Account\n3.Admin Portal\n4.Exit");
		ch=Integer.parseInt(br.readLine());
		if(ch==1)
		{
			String username=authenciation();
			System.out.println("1.Withdraw\n2.Deposit");
			System.out.println("Enter your choice: ");
			int option=Integer.parseInt(br.readLine());
			if(option==1)
			{
				System.out.println("Enter amount to withdraw: ");
				int amount=Integer.parseInt(br.readLine());
				if(!account.withdrawAmount(username,amount))
				System.out.println("Not Enough Balance");
				else {
					System.out.println("Amount Withdrawn Successfully");
				}
			}
			else
			{
				System.out.println("Enter the amount to deposit: ");
				int amount=Integer.parseInt(br.readLine());
				account.depositAmount(username,amount);
				System.out.println("Amount Added Successfully");
			}
			
				
		}
		else if(ch==2)
		{
			System.out.println("1.Saving Account\n2.Current Account\n3.Exit"); 
			System.out.println("Enter your Choice: ");
			int option=Integer.parseInt(br.readLine());
			if(option>=3)
			{
				System.out.println("Thankyou!!!!!!!!!!!!!");
				return;
			}
			System.out.println("Enter Name: ");
			String name=br.readLine();
			System.out.println("Enter Age: ");
			int age=Integer.parseInt(br.readLine());
			System.out.println("Enter Contact Number: ");
			long  contactNo=Long.parseLong(br.readLine());
			System.out.println("Enter Address: ");
			String address=br.readLine();
			System.out.println("Enter AadharCard Number: ");
			String aadharCardNumber=br.readLine();
			
			if(option==1)
			{
				if(account.addAccount(name,age,contactNo,address,aadharCardNumber,"saving",name+"@sbi.com",name+"@123"))
					System.out.println("Account Created Successfully");
				else
					System.out.println("Unsuccessfull");
				
				
			}
			else if(option==2)
			{
				if(account.addAccount(name,age,contactNo,address,aadharCardNumber,"current",name+"@sbi.com",name+"@123"))
					System.out.println("Account Created Successfully");
				else
					System.out.println("Unsuccessfully");
			}

		}
		else if(ch==3)
		{
			 authenciation();
			 System.out.println("1.All Account Details\n2.Search Account\n3.Delete Account\n4.Exit");
			 int option=Integer.parseInt(br.readLine());
			 if(option==1)
				 account.allAccountDetails();
			 else if(option==2)
			 {
				 System.out.println("Enter the UserName: ");
				 String username=br.readLine();
				 account.searchAccount(username);
			 }
			 else if(option==3) 
			 {
				 System.out.println("Enter the UserName: ");
				 String username=br.readLine();
				 account.deleteAccount(username);
			}
			 else {
				return ;
			}
		}
		else {
			return ;
		}
			
		System.out.println("Do you want to Continue");
		flag = (char)br.readLine().charAt(0);
	} while (flag=='y');
	
}
}
