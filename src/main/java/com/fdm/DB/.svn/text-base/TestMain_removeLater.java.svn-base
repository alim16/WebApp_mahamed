package com.fdm.DB;

import java.util.ArrayList;
import java.util.List;





public class TestMain_removeLater {

	public static void main(String[] args) {
	
		String url = "jdbc:oracle:thin:@oracle.fdmgroup.com:1521:xe"; 
		String username = "mahamedali";    
		String pass = "Oracle101";
		ConnectionPool cp = ConnectionPool.getInstance(url,username,pass);
/*
		UsersDAO da = new UsersDAO(cp); 
		User testUser = new User(); 
		
		testUser.setUserName("user2");
		testUser.setPassword("pass"); 
		
		//da.addUser(testUser);
		//
		//da.remove(testUser.getUserName());
		User user = da.get("user1");
		System.out.println(user.getPassword());
		*/
		
		CompaniesDAO da = new CompaniesDAO(cp); 
		//Company comp = new Company();
		//comp = da.get("Toyota");
		//System.out.println(comp.getPlace_ID());
		List<String> compList = da.getAll("T");
		
		//compList = da.getAll("T");
		System.out.println(compList.get(1));
		
	}

}
