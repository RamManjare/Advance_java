package com.dal;

//import java.sql.SQLException;
import java.util.List;

import com.pojo.Account;

public interface BankDAL {
//CRUD for Accounts
	//Do in Lab
	//insert update delete
	//String moneyTransfer(int sId,int rId,double amount) throws SQLException ;
	//CRUD
		//select * from book;
		List<Account> getallAccounts();
		//add new book
		int addAccount(Account acc);
		
		//update
		int updateAccount(Account acc);
		//delete book
		
		int deleteAccount(int id);
}
