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
public class CreateUserFavorites extends HttpServlet {
	
	protected UserFavoritesDao favoritesDao;
	protected UserDao userDao;

	@Override
	public void init() throws ServletException {
		
		favoritesDao = UserFavoritesDao.getInstance();
		userDao = UserDao.getInstance();
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
          
        String userId = req.getParameter("userId");
        if (userId == null || userId.trim().isEmpty()) {
        	messages.put("success", "Please enter a valid UserId.");
        } else {
        	try {
        		int userIdInt = Integer.parseInt(userId);
        		User user = userDao.getUserByUserId(userIdInt);
        		if(user == null) {
        			messages.put("success", "UserId does not exist.");
        		} else {
        			UserFavorites favorites = new UserFavorites(user);
        			favorites = favoritesDao.create(favorites);
        			messages.put("success", "Successfully created a UserFavorites Playlist for userId " + userId);
        			req.setAttribute("favorites", favorites);
        		}
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        req.getRequestDispatcher("/CreateUserFavorites.jsp").forward(req, resp);
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/CreateUserFavorites.jsp").forward(req, resp);
	}
	
	

}
