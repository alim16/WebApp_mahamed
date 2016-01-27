package com.fdm.DB;


import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDAO implements IStorage{

	
	private ConnectionPool pool;	

	public UsersDAO(ConnectionPool pool ) {
		this.pool = pool;
	}

	
	public void addUser(User user) {
		String query = "{ call add_user(?,?,?,?,?,?) }";
		Connection con = null;
	    CallableStatement callSt = null;
		try {
			con = pool.checkout();
			callSt = con.prepareCall(query);
			callSt.setString(1, user.getUserName());
			callSt.setString(2, user.getPassword());
			callSt.setString(3, user.getFirstName());
			callSt.setString(4, user.getLastName());
			callSt.setLong(5, user.getRole());
			if (user.isEnable() == true){
				callSt.setLong(6, 1);
			}else{
				callSt.setLong(6, 0);
			}
			callSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeStatement(callSt);
			pool.checkin(con);
		}
	}


	public void closeStatement(CallableStatement callSt) {
		if (callSt!=null){
			try {
				callSt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void remove(String userName) {
		String query = "{ call remove_user(?) }";
		Connection con = null;
	    CallableStatement callSt = null;
		try {
			con = pool.checkout();
			callSt = con.prepareCall(query);
			callSt.setString(1, userName);
			callSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{	
			
			closeStatement(callSt);
			pool.checkin(con);
		}
	}

	public User get(String userName) {
		Connection con = null;
		String query = "SELECT * FROM users WHERE username = ?" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
			try {
				con = pool.checkout();
				ps = con.prepareStatement(query);
				ps.setString(1, userName);	
				rs = ps.executeQuery();
				if(rs.next()){
					user = new User();
					user.setUserName(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				closeAllForGetMethod(rs,ps,con);
			}
			
		return user;
	}


	public void closeAllForGetMethod(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
