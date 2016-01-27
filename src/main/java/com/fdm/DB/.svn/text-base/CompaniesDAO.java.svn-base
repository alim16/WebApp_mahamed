package com.fdm.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesDAO {
	private ConnectionPool pool;	

	public CompaniesDAO(ConnectionPool pool ) {
		this.pool = pool;
	}
	
	public Company get(String companyName) {
		Connection con = null;
		String query = "SELECT * FROM companies WHERE Name = ?" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Company company = null;
			try {
				con = pool.checkout();
				ps = con.prepareStatement(query);
				ps.setString(1, companyName);	
				rs = ps.executeQuery();
				if(rs.next()){
					company = new Company();
					company.setName(rs.getString("NAME"));
					company.setCompany_Id(Integer.parseInt((rs.getString("COMPANY_ID"))));	
					company.setPlace_ID(Integer.parseInt(rs.getString("PLACE_ID")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				closeAllForGetMethod(rs,ps,con);
			}
		return company;
	}
	
	public List<String> getAll(String str) {
		Connection con = null;
		String query = "SELECT name FROM companies WHERE Name LIKE ?" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> companyList = new ArrayList<String>(); 
		  
			try {
				con = pool.checkout();
				ps = con.prepareStatement(query);
				ps.setString(1, "%"+str+"%");	
				rs = ps.executeQuery();
				int i = 0;
				while(rs.next()){
					companyList.add(rs.getString("name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				closeAllForGetMethod(rs,ps,con);
			}
		return companyList;
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
