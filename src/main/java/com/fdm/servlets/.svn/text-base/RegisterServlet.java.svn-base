package com.fdm.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.DB.ConnectionPool;
import com.fdm.DB.User;
import com.fdm.DB.UsersDAO;

public class RegisterServlet extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("Reg servlet initialised");
		
	
		super.init();
	}
	
	RequestDispatcher dispatcher;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		UsersDAO da = new UsersDAO(	(ConnectionPool) getServletContext().getAttribute("pool")); 
		
		User TempUser = new User(); 

		
	//	HttpSession session = req.getSession();
		//session.setAttribute("pool", cp);
		//session.setAttribute("userDa", da);
		
		dispatcher = req.getRequestDispatcher("login.jsp");	
		TempUser.setUserName(req.getParameter("username"));
		TempUser.setPassword(req.getParameter("password")); 
		TempUser.setFirstName(req.getParameter("firstname"));
		TempUser.setLastName(req.getParameter("lastname"));
		//TempUser.setRole(Integer.valueOf( req.getParameter("lastname")));
		System.out.println("adding user...");
		da.addUser(TempUser);

		dispatcher.forward(req, resp);
	}
	

	@Override
	public void destroy() {
		System.out.println("Reg servlet destroyed");
		super.destroy();
	}

}
