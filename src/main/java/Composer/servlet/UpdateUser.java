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
public class UpdateUser extends HttpServlet {
	protected UserDao userDao;

	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userId = req.getParameter("userid");

        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserId.");
        } else {
        	try {
        		int userIdInt = Integer.parseInt(userId);
        		User user = userDao.getUserByUserId(userIdInt);
        		if(user == null) {
        			messages.put("success", "User does not exist.");
        		}
        		req.setAttribute("user", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UpdateUser.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userId = req.getParameter("userId");
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserId.");
        } else {
        	try {
        		int userIdInt = Integer.parseInt(userId);
        		User user = userDao.getUserByUserId(userIdInt);
        		if(user == null) {
        			messages.put("success", "UserId does not exist. No update to perform.");
        		} else {
        			String newLastName = req.getParameter("lastName");
        			if (newLastName == null || newLastName.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid LastName.");
        	        } else {
        	        	user = userDao.updateLastName(user, newLastName);
        	        	messages.put("success", "Successfully updated " + userId + " with the new last name: " + newLastName);
        	        }
        		}
        		req.setAttribute("user", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UpdateUser.jsp").forward(req, resp);
    }
	

}
