package com.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dal.AccountDALImpl;
import com.pojo.Account;
import com.util.DBUtil;


public class TestBankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DBUtil.openConnection();
			System.out.println("1:Show All Accounts 2: Add New Account  3:Update Account 4:Delete Account");
			AccountDALImpl actDal = new AccountDALImpl();

			
			int ch=0;
			Scanner sc= new Scanner(System.in);
			do {
				System.out.println("enter choice");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					List<Account> list=actDal.getallAccounts();
					list.forEach(b->System.out.println(b));
					break;
				
				case 2:
					
					System.out.println("Enter acct id name type balance");
					Account acc=new Account(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					int i=actDal.addAccount(acc);
					if(i>0)
					{
						System.out.println("Inserted");
					}
					break;
					
				case 3:
					System.out.println("Edit : id Newname Newtype Newbalance:");
					 acc=new Account(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					  i=actDal.updateAccount(acc);
					if(i>0)
					{
						System.out.println("Updated");
					}
					break;
					
				case 4:
					System.out.println("Enter id To Delete");
					int id=sc.nextInt();
					i=actDal.deleteAccount(id);
					if(i>0)
					{
						System.out.println("Deleted");
					}
					else
					{
						System.out.println("Not Found...");
					}
					break;
				}
				
			}
			while(ch!=5);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
