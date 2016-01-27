package com.fdm.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectionPool {

	private static int m_InitialConnectionCount = 1;
	private static List<Connection> m_AvailableConnections = Collections.synchronizedList(new ArrayList<Connection>()); 
	private static List<Connection> m_UsedConnections = Collections.synchronizedList(new ArrayList<Connection>());
	private static String m_URLString = null; 
	private static String m_UserName = null;    
	private static String m_Password = null;

	private static ConnectionPool instance;

	public static ConnectionPool getInstance(String urlString, String user, String passwd){
		if (instance == null){
			try {
				instance = new ConnectionPool(urlString, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	private ConnectionPool(String urlString, String user, String passwd) throws SQLException {
		m_URLString = urlString; 
		m_UserName = user; 
		m_Password = passwd; 

		for(int cnt=0; cnt < m_InitialConnectionCount; cnt++) { 
			m_AvailableConnections.add(getConnection()); 
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Running Shutdown Hook");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Connection getConnection(){ 
		Connection connection = null;
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(m_URLString, m_UserName, m_Password);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return connection;
	}

	public synchronized Connection checkout() throws SQLException { 
		Connection newConnxn = null; 
		if(m_AvailableConnections.size() == 0) { 
			newConnxn = getConnection();
			m_UsedConnections.add(newConnxn); 
		} 
		else { 
			newConnxn = (Connection) m_AvailableConnections.get(0); 

			m_AvailableConnections.remove(newConnxn); 
			m_UsedConnections.add(newConnxn);             
		}         
		return newConnxn; 
	} 
	public synchronized void checkin(Connection c) { 
		if(c != null){
			m_UsedConnections.remove(c);
			if(m_AvailableConnections.size() < m_InitialConnectionCount){
				m_AvailableConnections.add(c);
			} else{
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}             
	public int availableCount() { 
		return m_AvailableConnections.size(); 
	}

}