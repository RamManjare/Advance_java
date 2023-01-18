package com.dal;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


import com.pojo.Account;

import com.util.DBUtil;

public class AccountDALImpl implements BankDAL {

	//
	private Connection con;
	 
	private ResultSet rset;
	
	private Statement stmt;
	private PreparedStatement pstmt1,pstmt2,pstmt3;
	  public AccountDALImpl() throws SQLException {
		  con=DBUtil.getCon();
		  stmt= con.createStatement();
		  pstmt1=con.prepareStatement("insert into bank values(?,?,?,?)");
		  pstmt2=con.prepareStatement("update bank set name=? ,type=? ,balance=? where id=?");
			pstmt3=con.prepareStatement("delete from  bank  where id=?");
			
 
		
		
		 System.out.println("---account dal created----"); 
		  
		  
	}
	
	
	 
	
	
	@Override
	public List<Account> getallAccounts(){
		try{
			List<Account> allacc=new ArrayList<Account>();
		rset=stmt.executeQuery("select * from bank");
		while(rset.next()) {
			allacc.add(new Account(rset.getInt("id"),
					rset.getString("name"),
					rset.getString("type"),
					rset.getDouble("balance")));
		}
		return allacc;
	}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
	@Override
	public int addAccount(Account acc){
		try{pstmt1.setInt(1, acc.getId());
		pstmt1.setString(2, acc.getName());
		pstmt1.setString(3, acc.getType());
		pstmt1.setDouble(4, acc.getBalance());
		int i=pstmt1.executeUpdate();
		System.out.println("---inserted acc:"+acc);
		return i;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	@Override
	public int updateAccount(Account acc){
		
		 
			 
		try {	pstmt2.setString(1,acc.getName());
			 
			pstmt2.setString(2, acc.getType());				 		
			pstmt2.setDouble(3, acc.getBalance());
			pstmt2.setInt(4, acc.getId());
			 int i=pstmt2.executeUpdate();//Write: Insert ,Update Delete
			System.out.println("---updated acc:"+acc);
			return i;
					
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		 
		try {	pstmt3.setInt(1, id);
			int i=pstmt3.executeUpdate();
			System.out.println("---deleted acc:"+id);
			return i;
	
}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}