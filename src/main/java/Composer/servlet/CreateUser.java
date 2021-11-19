package Composer.servlet;

import Composer.dal.*;
import Composer.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet
public class CreateUser extends HttpServlet {

	protected UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String firstName = req.getParameter("firstName");
        if (firstName == null || firstName.trim().isEmpty()) {
            messages.put("success", "Invalid firstName");
        } else {
        	String lastName = req.getParameter("lastName");
        	try {
        		User user = new User(firstName, lastName);
        		user = userDao.create(user);
        		messages.put("success", "Successfully created " + firstName);
        	} catch (SQLException e) {
        		e.printStackTrace();
        		throw new IOException(e);
        	}
        }
        req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);
	}
	

}
