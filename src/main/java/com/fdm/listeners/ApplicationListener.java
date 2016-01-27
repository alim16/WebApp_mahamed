package com.fdm.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdm.DB.ConnectionPool;
import com.fdm.DB.UsersDAO;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		System.out.println("context initialised");
		
		
		String url = "jdbc:oracle:thin:@oracle.fdmgroup.com:1521:xe"; 
		String username = "mahamedali";    
		String pass = "Oracle101";
		ConnectionPool cp = ConnectionPool.getInstance(url,username,pass);
		context.setAttribute("pool", cp);
	//	UsersDAO UsersDao = new UsersDAO(	cp);
		//context.setAttribute("UsersDao", UsersDao);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
