package com.fdm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.DB.CompaniesDAO;
import com.fdm.DB.ConnectionPool;
import com.fdm.DB.UsersDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;
       
	@Override
	public void init() throws ServletException {
		System.out.println("Login servlet initialised");
	
		super.init();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		System.out.println(getServletContext().getAttribute("pool"));
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatcher = req.getRequestDispatcher("home.jsp");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("pool");
	//	UsersDAO da = (UsersDAO) session.getAttribute("userDa");
		UsersDAO da = new UsersDAO(cp); 
	
		
		da.get(username);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
	
		CompaniesDAO ca = new CompaniesDAO(cp); 
		List<String> compList = ca.getAll("");	
		req.setAttribute("companies", compList);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
